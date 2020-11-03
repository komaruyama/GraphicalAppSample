package com.example.graphicalappsample;

public class GuiViewInformation {
    public static GuiViewInfoItem information[] = {
        new GuiViewInfoItem(
                "サンプル1 ニュースサイト",
                "写真や文字列が表示され、上下にスクロールできます。",
                null),
    };
}

class GuiViewInfoItem{
    String name;
    String description;
    Class<GuiViewInterface> clazz;

    public GuiViewInfoItem(String name, String description, Class<GuiViewInterface> clazz){
        this.name = name;
        this.description = description;
        this.clazz = clazz;
    }
}
