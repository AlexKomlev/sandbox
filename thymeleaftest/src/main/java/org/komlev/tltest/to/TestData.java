package org.komlev.tltest.to;

import java.util.List;

/**
 * Description.
 *
 * @author <a href="mailto:AlexKomlev@rambler.ru">Aleksey Komlev</a>
 * @version 13.09.13
 */
public class TestData {
    private String text;

    private String delta;

    public String getText() {
        return text;
    }

    public String getDelta() {
        return delta;
    }

    public TestData(String text, String delta) {
        this.text = text;
        this.delta = delta;
    }
}
