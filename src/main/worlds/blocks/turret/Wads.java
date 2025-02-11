package main.worlds.blocks.turret;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.gen.Bullet;
import mindustry.gen.Groups;
import mindustry.gen.Sounds;
import mindustry.gen.Teamc;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

public class Wads extends PowerTurret {

    public float waterConsumption = 0.1f; // 默认水消耗速度
    public float waterBoost = 1.5f; // 默认水冷却带来的攻击频率提升
    public float baseReload = 60f; // 默认基础射速（60 帧 = 1 秒）
    public float idleRotationSpeed = 360f / 120f; // 默认待机旋转速度（2 秒一圈）

    public Wads(String name) {
        super(name);

        // 默认属性
        shootCone = 360f; // 360 度全覆盖
        targetAir = false; // 不针对空中单位
        targetGround = false; // 不针对地面单位
        shootSound = Sounds.laser; // 射击音效
    }

    @Override
    public void setStats() {
        super.setStats();
        stats.remove(Stat.ammo); // 移除弹药统计
        stats.remove(Stat.targetsAir); // 移除对空目标统计
        stats.remove(Stat.targetsGround); // 移除对地目标统计
        stats.add(Stat.liquidCapacity, waterConsumption * 60f, StatUnit.perSecond); // 显示水消耗
    }

    public class ADSBuild extends PowerTurretBuild {

        protected Bullet target; // 当前目标
        protected float laserLength; // 激光长度
        protected float hitEffectTime; // 命中效果时间
        protected float hitEffectSize = 10f; // 命中效果大小

        @Override
        public void updateTile() {
            super.updateTile();

            // 如果没有电力，直接返回
            if (power.status <= 0.01f) return;

            // 计算攻击频率（如果有水，则提升攻击频率）
            float reloadTime = baseReload / (liquids.currentAmount() > 0 ? waterBoost : 1f);
            reloadTime /= power.status; // 根据电力状态调整射速

            // 查找目标
            if (timer.get(0, reloadTime)) {
                Teamc targetTeamc = findTarget();
                if (targetTeamc instanceof Bullet) {
                    target = (Bullet) targetTeamc;
                    shoot(target);
                }
            }

            // 待机状态下缓慢旋转
            if (target == null) {
                rotation += idleRotationSpeed * Time.delta * power.status;
            }

            // 更新命中效果
            if (hitEffectTime > 0) {
                hitEffectTime -= Time.delta;
                if (hitEffectTime <= 0) {
                    hitEffectTime = 0;
                }
            }
        }

        // 查找范围内的敌方炮弹或导弹
        @Override
        protected Teamc findTarget() {
            return Groups.bullet.intersect(x - range, y - range, range * 2, range * 2)
                    .min((Bullet b) -> b.team != team && b.type() != null && b.type().collidesTiles, (Bullet b) -> b.dst2(x, y));
        }

        // 射击目标
        protected void shoot(Bullet target) {
            if (target != null) {
                // 计算激光长度
                laserLength = Mathf.dst(x, y, target.x, target.y);

                // 命中目标
                target.damage(50); // 造成伤害
                target.remove(); // 摧毁目标

                // 触发命中效果
                hitEffectTime = 0.2f;
                hitEffectSize = 10f;
            }
        }

        @Override
        public void draw() {
            super.draw();

            // 绘制激光
            if (target != null && laserLength > 0) {
                Draw.color(Color.green);
                Lines.stroke(2f);
                Lines.line(x, y, target.x, target.y);
                Draw.reset();
            }

            // 绘制命中效果
            if (hitEffectTime > 0) {
                Draw.color(Color.green);
                Lines.stroke(2f);
                Lines.circle(target.x, target.y, hitEffectSize * (hitEffectTime / 0.2f));
                Draw.reset();
            }
        }
    }
}