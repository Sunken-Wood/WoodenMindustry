package main.ui;

import arc.Core;
import arc.scene.ui.layout.Table;
import arc.util.Time;
import mindustry.game.EventType;
import mindustry.gen.Tex;
import mindustry.ui.dialogs.BaseDialog;

// EnterPlanetStoryUi 类继承自 BaseDialog，用于创建一个自定义的对话框
public class EnterPlanetStoryUi extends BaseDialog {

    // toShow 方法用于显示对话框内容
    public void toShow(){
        // 清除对话框内容区域
        cont.clear();

        // 创建一个新的 Table 对象，用于布局对话框内容
        Table hello = new Table();
        // 添加 "Hello" 文本，并跨两列
        hello.add("Hello").colspan(2);
        hello.row();

        // 在 hello 表格中添加一个按钮，点击按钮后会触发一个事件
        hello.table(Tex.button, diff -> {
            // 使用 Time.runTask 在 10 秒后执行一个任务
            Time.runTask(10f, () -> {
                // 创建一个新的 BaseDialog 对象，标题为 "frog"
                BaseDialog dialog = new BaseDialog("frog");
                // 在对话框内容区域添加 "behold" 文本
                dialog.cont.add("behold").row();
                // 在对话框内容区域添加一个图片，图片名称为 "frog"，并设置内边距为 20f
                dialog.cont.image(Core.atlas.find("frog")).pad(20f).row();
                // 在对话框内容区域添加一个按钮，按钮文本为 "I see"，点击按钮后隐藏对话框
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                // 显示对话框
                dialog.show();
            });
        });
    }

    // EnterPlanetStoryUi 构造函数，调用父类 BaseDialog 的构造函数，设置对话框标题为 "hello"
    public EnterPlanetStoryUi() {
        super("hello");
    }
}
