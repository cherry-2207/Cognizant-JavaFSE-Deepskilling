package com.demo;

public abstract class DocumentFactory {
    public abstract Document createDocument();
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
    }
}
