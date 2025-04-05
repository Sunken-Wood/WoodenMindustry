package content;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.with;


public class WBlocks {
    public static Unloader unloader;

    public static void load(){
        // 电力桥

        // 定向防御发生器

        // 干扰塔

        // 高效传送桥（待定）

        // 高效交叉器（待定）

        // 高效冷凝器

        // 高效路由器（待定）

        // 高压涡轮机

        // 熔融

        // 提取器
        unloader = new Unloader("unloader"){{
            requirements(Category.effect, with(Items.graphite, 20, Items.silicon, 20, Items.tungsten, 10));
            // 设置卸载速度为 60 帧/秒 / 11 帧/秒
            speed = 60f / 11f;
            // 设置块组为 Transportation
            group = BlockGroup.transportation;
        }};

        // 顶点探测仪（待定）
    }
}
