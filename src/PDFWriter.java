import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.LinkedList;

public class PDFWriter {

    private String path = "C:\\Users\\manue\\Desktop\\notentabelle.pdf";
//    private String path = "C:\\Users\\ManuBoss\\Desktop\\notentabelle.pdf";
    private PDDocument doc;
    private PDPage page;


    PDFWriter(double gradeWithHalfAmounts, LinkedList<Double> grades, LinkedList<Double> lowPoints,
              LinkedList<Double> highPoints) throws IOException {
        this.doc = new PDDocument();
        this.page = new PDPage();
        doc.addPage(page);


        page = doc.getPage(0);

        PDPageContentStream cs = initContentStream( 25, 740, false, 16);
        cs.showText("Notentabelle");
        endAndCloseStream(cs);

        PDPageContentStream cs2 = initContentStream(40, 725, false, 14);
        cs2.setLeading(15f);
        cs2.showText("Maximale Punkte: " + highPoints.getLast());
        cs2.newLine();
        cs2.showText("Note bei halber Punktzahl: " + gradeWithHalfAmounts);
        endAndCloseStream(cs2);

        PDPageContentStream cs3 = initContentStream(40, 670, false, 14);
        cs3.setLeading(23f);
        for (int i = 0; i < 17; i++) {
            cs3.newLine();
            if (Double.compare(lowPoints.get(i), highPoints.get(i)) == 0) {
//                cs3.showText(lowPoints.get(i) + ": " + grades.get(i));
                cs3.showText(String.valueOf(lowPoints.get(i)));
                cs3.endText();
                cs3.moveTo(150, 0);
                cs3.beginText();
                cs3.showText(String.valueOf(grades.get(i)));
        }
            else {
                cs3.showText(lowPoints.get(i) + " - " + highPoints.get(i) + ": " + grades.get(i));
                cs3.endText();
                cs3.moveTo(150, 0);
                cs3.beginText();
                cs3.showText(String.valueOf(grades.get(i)));
            }
        }
        endAndCloseStream(cs3);

        PDPageContentStream cs4 = initContentStream(200, 670, false, 14);
        cs4.setLeading(23f);
        for (int i = 17; i < 34; i++) {
            cs4.newLine();
            if (Double.compare(lowPoints.get(i), highPoints.get(i)) == 0)
                cs4.showText(lowPoints.get(i) + ": " + grades.get(i));
            else {
                cs4.showText(lowPoints.get(i) + " - " + highPoints.get(i) + ": " + grades.get(i));
            }
        }
        endAndCloseStream(cs4);

        PDPageContentStream cs5 =initContentStream(360, 670, false, 14);
        cs5.setLeading(23f);
        for (int i = 34; i < 51; i++) {
            cs5.newLine();
            if (Double.compare(lowPoints.get(i), highPoints.get(i)) == 0)
                cs5.showText(lowPoints.get(i) + ": " + grades.get(i));
            else {
                cs5.showText(lowPoints.get(i) + " - " + highPoints.get(i) + ": " + grades.get(i));
            }
        }
        endAndCloseStream(cs5);
    }

    private void endAndCloseStream(PDPageContentStream cs) throws IOException {
        cs.endText();
        cs.close();
    }

    public void save() throws IOException {
        this.doc.save(path);
        this.doc.close();
        System.out.println("gespeichert");
    }

    public PDPageContentStream initContentStream(float xPos, float yPos, boolean fontFat, int fontSize) throws IOException {

        PDPageContentStream stream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true);
        stream.beginText();
        stream.newLineAtOffset(xPos, yPos);
        if(!fontFat)
            stream.setFont(PDType1Font.TIMES_ROMAN, fontSize);
        else
            stream.setFont(PDType1Font.TIMES_BOLD, fontSize);
        return stream;
    }
}

