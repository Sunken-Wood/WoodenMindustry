//想给炮台搞个特效，奈何心有余而力不足
package main.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;

import javax.print.attribute.standard.PrinterMakeAndModel;

public class WFx {
    public static Effect spearKH = new Effect(40,e ->{
        Draw.color(Color.blue);
        float[] radii = {15f,10f,5f};
        for (int i =0; i < radii.length; i++) {
            float radius = radii[i] * e.fout();
            Drawf.circles(e.x, e.y,radius);
        }
        Draw.color(Color.blue,Color.blue.cpy().a(0),e.fin());
    });

    public static Effect spearKHH (Color cor,Color lic){//没写完，先别动
        return new Effect(72, e -> {
            Draw.color(lic, cor, e.fin());

            float firstRadius = 40 * e.fout();
            Fill.circle(e.x, e.y, firstRadius);
            Lines.stroke(e.fout() * 4.5f);
            Lines.circle(e.x, e.y,firstRadius * 1.5f);

            if (e.fin() >0.5f){
                float secondAlpna = (e.fin() - 0.5f) * 2;
                float secondRadius = 30 * secondAlpna;
                Lines.stroke(secondAlpna *2.75f);
                Lines.circle(e.x, e.y, secondRadius);
            }
            if (e.fin() > 0.75f) {
                float thirdAlpha = (e.fin() - 0.75f) * 4;
                float thirdRadius = 20 * thirdAlpha;
                Lines.stroke(thirdAlpha * 2);
                Lines.circle(e.x, e.y,thirdRadius);
            }

        });
    }
}
