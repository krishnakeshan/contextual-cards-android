package com.test.fampaydemo.data.model;

import java.util.List;

public class Card {
    private String name;
    private String title;
    private String description;
    private FormattedText formattedTitle;
    private FormattedText formattedDescription;
    private Icon icon;
    private String url;
    private boolean isDisabled;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public FormattedText getFormattedTitle() {
        return formattedTitle;
    }

    public FormattedText getFormattedDescription() {
        return formattedDescription;
    }

    public Icon getIcon() {
        return icon;
    }

    public String getUrl() {
        return url;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public static class FormattedText {
        private String text;
        private List<FormattedTextEntity> entities;

        public String getText() {
            return text;
        }

        public List<FormattedTextEntity> getEntities() {
            return entities;
        }
    }

    public static class FormattedTextEntity {
        private String text;
        private String color;
        private String url;
        private String fontStyle;

        public String getText() {
            return text;
        }

        public String getColor() {
            return color;
        }

        public String getUrl() {
            return url;
        }

        public String getFontStyle() {
            return fontStyle;
        }
    }

    static class FontStyles {
        private static final String UNDERLINE = "underline";
        private static final String ITALIC = "italic";
    }

    static class Icon {
        private ImageType imageType;
        private String imageUrl;
    }
}

enum ImageType {
    EXT
}
