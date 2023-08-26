package com.esvarog.dekanat.fileGen;

import com.esvarog.dekanat.security.global_param;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class accounting_for_success {
    private static final String FILE = "C:/fileDownload/accounting_for_success.pdf";

    private static final Font small = FontFactory.getFont("fonts/Royal_Times_New_Roman.ttf", "cp1251", BaseFont.EMBEDDED, 8);
    private static final Font smallBold = FontFactory.getFont("fonts/Royal_Times_New_Roman.ttf", "cp1251", BaseFont.EMBEDDED, 8, Font.BOLD);
    private static final Font medium = FontFactory.getFont("fonts/Royal_Times_New_Roman.ttf", "cp1251", BaseFont.EMBEDDED, 12);
    private static final Font mediumBold = FontFactory.getFont("fonts/Royal_Times_New_Roman.ttf", "cp1251", BaseFont.EMBEDDED, 12, Font.BOLD);



//todo Розробити систему регулювання тексту по ширині, з умовою зміни його ширини


    public static void pdfGen(String titleFaculty, String titleSpeciality, String edu_program, String courseNumber,
                              String abrSpec, String numberOfInformation, String date, String month,
                              String titleOfDisc, String numberOfSemester, String type_of_control, String hours,
                              String firstTeach, boolean firstTeach_bool, String secondTeach, boolean secondTeach_bool,
                              String dean_name){
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();




            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            float x = 560;


            setTextLeft(x, 632, "Група     _______________________________", writer);
            setTextLeftSmall(x-418, 485, "(номер семестру)", writer);
            setTextLeftSmall(x-260, 449, " (назва типу контроля)", writer);
            setTextLeftSmall(x-20, 449, "(години)", writer);
            setTextLeftSmall(x-120, 412, "(Вчене звання, призвіще та ім'я викладача, який виставляє підсумкову оцінку)", writer);
            setTextLeftSmall(x-115, 376, "(Вчене звання, призвіще та ім'я викладача, який здійснював поточний контроль)", writer);

            setTextLeft(x, 705, titleFaculty, writer);
            setTextLeft(x, 687, titleSpeciality, writer);
            setTextLeft(x, 669, edu_program, writer);
            setTextLeft(x- 440, 633, courseNumber, writer);
            setTextLeft(x-90, 632, abrSpec, writer);
            setTextLeft(x-150, 580, numberOfInformation, writer);
            setTextLeft(x-450, 495, numberOfSemester, writer);

            setTextLeft(x-335, 560, date, writer); //date
            setTextLeft(x-240, 560, month, writer); //month
            setTextLeft(295, 525, titleOfDisc, writer); //title of disc

            setTextLeft(x-275, 458, type_of_control, writer);//type_of_control
            setTextLeft(x-27, 458, hours, writer);//hours


            setTextLeft(500, 422, firstTeach, writer);//first teacher
            setTextLeft(150, 386, secondTeach, writer);//second teacher


            addTitlePage(document, numberOfSemester);


            setTextLeftSmall(x-315, 436, "(підпис)", writer);
            setTextLeftSmall(x-75, 436, "(ім'я, прізвище)", writer);

            setTextLeft(x-85, 446, dean_name, writer); //  ім'я, прізвище декана
            setTextLeftSmall(x-295, 191, "(підпис)", writer);
            String teach = "";
            if (firstTeach_bool){
                teach = firstTeach;
            } else if (secondTeach_bool) {
                teach = secondTeach;
            }
            setTextLeft(x-80, 201, teach, writer);
            setTextLeftSmall(x-75, 191, "(ім'я, прізвище)", writer);



            document.close();
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }
}

    private static void setTextLeft(float x, int y1, String text1, PdfWriter writer) {
        PdfContentByte canvas = writer.getDirectContent();
        float text_length1 = calculateTextWidthInPixels(text1, 12, medium.getBaseFont());
        canvas.beginText();
        canvas.moveText(x - text_length1 * 1.34f, y1); // Move the starting point
        canvas.setFontAndSize(medium.getBaseFont(), 12);
        canvas.showText(text1);
        canvas.endText();
    }

    private static void setTextLeftSmall(float x, int y1, String text1, PdfWriter writer) {
        PdfContentByte canvas = writer.getDirectContent();
        float text_length1 = calculateTextWidthInPixels(text1, 8, medium.getBaseFont());
        canvas.beginText();
        canvas.moveText(x - text_length1 * 1.34f, y1); // Move the starting point
        canvas.setFontAndSize(small.getBaseFont(), 8);
        canvas.showText(text1);
        canvas.endText();
    }

    private static String getYear(String sem){
            String YEAR = "";
            if (sem.equals("1") || sem.equals("3")){
                YEAR = global_param.YEAR_OF_STUDY.split("/")[0];
            }
            if (sem.equals("2") || sem.equals("4")){
                YEAR = global_param.YEAR_OF_STUDY.split("/")[1];
            }
            else {
                System.out.println("Семестр не знайдений");
            }
        return YEAR;
    }

    private static void addTitlePage(Document document, String sem) throws DocumentException, FileNotFoundException {
        LineSeparator lineSeparator = new LineSeparator();
        Paragraph paragraph1 = new Paragraph("""
                ЗАТВЕРДЖЕНО                              \s
                Наказ Міністерства освіти і науки \s
                України 05 липня 2016 року №782""", small); //TODO дата повинна братися під час створення документу
        paragraph1.setAlignment(Element.ALIGN_RIGHT);
        addEmptyLine(paragraph1);
        document.add(paragraph1);




        Paragraph paragraph2 = new Paragraph("Форма № Н-5.03", smallBold);
        paragraph2.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph2);



        Paragraph paragraph3 = new Paragraph("НАЦІОНАЛЬНИЙ ТРАНСПОРТНИЙ УНІВЕРСИТЕТ" , medium);
        paragraph3.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph3);
        lineSeparator.setOffset(-2);
        document.add(lineSeparator);



        Paragraph paragraph4 = new Paragraph("Факультет", medium);
        document.add(paragraph4);
        lineSeparator.setOffset(-2);
        document.add(lineSeparator);



        Paragraph paragraph5 = new Paragraph("Спеціальність", medium);
        document.add(paragraph5);
        lineSeparator.setOffset(-2);
        document.add(lineSeparator);



        Paragraph paragraph6 = new Paragraph("Освітня програма( спеціалізація)", medium);
        document.add(paragraph6);
        lineSeparator.setOffset(-2);
        document.add(lineSeparator);

        Paragraph paragraph7 = new Paragraph(" ", medium);
        document.add(paragraph7);


        Paragraph paragraph8 = new Paragraph("Курс     ______________", medium);
        document.add(paragraph8);

        Paragraph paragraph9 = new Paragraph(global_param.YEAR_OF_STUDY + " навчальний рік", medium);
        paragraph9.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(paragraph9);
        document.add(paragraph9);


        Paragraph paragraph10 = new Paragraph("ВІДОМІСТЬ ОБЛІКУ УСПІШНОСТІ № ___________", mediumBold);
        paragraph10.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph10);


        Paragraph paragraph11 = new Paragraph("\"_____\"____________________" + getYear(sem) + "р", medium);//TODO зміна року
        paragraph11.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(paragraph11);
        document.add(paragraph11);


        Paragraph paragraph12 = new Paragraph("з", medium);
        document.add(paragraph12);
        lineSeparator.setOffset(-2);
        document.add(lineSeparator);

        Paragraph paragraph13 = new Paragraph("(назва дисципліни)", small);
        paragraph13.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph13);


        Paragraph paragraph14 = new Paragraph("за   ____________________   навчальний семестр.", medium);
        addEmptyLine(paragraph14);
        document.add(paragraph14);

        Paragraph paragraph15 = new Paragraph("Форма семестрового контролю   ____________________            Загальна кількість годин   __________", medium);
        addEmptyLine(paragraph15);
        document.add(paragraph15);


        Paragraph paragraph16 = new Paragraph("Викладач", medium);
        document.add(paragraph16);
        lineSeparator.setOffset(-2);
        document.add(lineSeparator);

        document.add(paragraph7);

        document.add(paragraph16);
        lineSeparator.setOffset(-2);
        document.add(lineSeparator);
        document.add(paragraph7);

        PdfPTable table = getPdfPTable();
        document.add(table);

        document.newPage();

        PdfPTable table2 = getPdfPTable2();
        document.add(table2);

        Paragraph paragraph17 = new Paragraph(" ", medium);
        document.add(paragraph17);

        Paragraph paragraph18 = new Paragraph("Декан факультету              _____________________             _____________________________________", medium);
        document.add(paragraph18);

        Paragraph paragraph19 = new Paragraph(" ", medium);
        document.add(paragraph19);

        Paragraph paragraph20 = new Paragraph("Підсумки складання екзамену (заліку)", mediumBold);
        paragraph20.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(paragraph20);
        document.add(paragraph20);

        PdfPTable table3 = getPdfPTable3();
        document.add(table3);

        Paragraph paragraph21 = new Paragraph(" ", medium);
        document.add(paragraph21);

        Paragraph paragraph22 = new Paragraph("Екзаменатор (викладач)     __________________________     ___________________________________", medium);
        document.add(paragraph22);




    }

    private static void getPdfPCell(PdfPTable table, String text, Font font, boolean row, int amount_row, boolean col, int amount_cell){
        PdfPCell cell = new PdfPCell(new Paragraph(text, font));
        if (row){
            cell.setRowspan(amount_row);
        }
        if (col){
            cell.setColspan(amount_cell);
        }
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        table.addCell(cell);

    }

    private static PdfPTable getPdfPTable() throws DocumentException {
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);
        table.setWidths(new float[] {1/5.2f, 1/0.7f, 1/0.9f, 1/1.1f, 1/1.19f, 1/2.2f, 1/2f, 1/1.5f});

        //1 row
        getPdfPCell(table, "№ з  /  п", medium, true , 2, false, 0);
        getPdfPCell(table, "Прізвище та ініціали студента", medium, true , 2, false, 0);
        getPdfPCell(table, "№ індивідуального навчального плану", medium, true , 2, false, 0);
        getPdfPCell(table, "Оцінка", medium, false , 0, true, 3);
        getPdfPCell(table, "Дата", medium, true , 2, false, 0);
        getPdfPCell(table, "Підпис викла- дача", medium, true , 2, false, 0);

        //2 row
        getPdfPCell(table, "за національною шкалою", medium, false , 0, false, 0);
        getPdfPCell(table, "кількість балів за 100 бальною шкалою", medium, false , 0, false, 0);
        getPdfPCell(table, "ECTS", medium, false , 0, false, 0);



        create_row(table, "1", "2", "3", "4", "5", "6", "7", "8");
        create_row(table, "1", " ", " ", "", "", "", "", "");
        create_row(table, "2", " ", " ", "", "", "", "", "");
        create_row(table, "3", " ", " ", "", "", "", "", "");
        create_row(table, "4", " ", " ", "", "", "", "", "");
        create_row(table, "5", " ", " ", "", "", "", "", "");
        create_row(table, "6", " ", " ", "", "", "", "", "");
        create_row(table, "7", " ", " ", "", "", "", "", "");
        create_row(table, "8", " ", " ", "", "", "", "", "");
        create_row(table, "9", " ", " ", "", "", "", "", "");
        create_row(table, "10", " ", " ", "", "", "", "", "");
        create_row(table, "11", " ", " ", "", "", "", "", "");
        create_row(table, "12", " ", " ", "", "", "", "", "");
        create_row(table, "13", " ", " ", "", "", "", "", "");
        create_row(table, "14", " ", " ", "", "", "", "", "");
        create_row(table, "15", " ", " ", "", "", "", "", "");

        return table;
    }

    private static PdfPTable getPdfPTable2() throws DocumentException {
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);
        table.setWidths(new float[] {1/5.2f, 1/0.7f, 1/0.9f, 1/1.1f, 1/1.19f, 1/2.2f, 1/2f, 1/1.5f});

        //1 row
        getPdfPCell(table, "№ з  /  п", medium, true , 2, false, 0);
        getPdfPCell(table, "Прізвище та ініціали студента", medium, true , 2, false, 0);
        getPdfPCell(table, "№ індивідуального навчального плану", medium, true , 2, false, 0);
        getPdfPCell(table, "Оцінка", medium, false , 0, true, 3);
        getPdfPCell(table, "Дата", medium, true , 2, false, 0);
        getPdfPCell(table, "Підпис викла- дача", medium, true , 2, false, 0);

        //2 row
        getPdfPCell(table, "за національною шкалою", medium, false , 0, false, 0);
        getPdfPCell(table, "кількість балів за 100 бальною шкалою", medium, false , 0, false, 0);
        getPdfPCell(table, "ECTS", medium, false , 0, false, 0);



        create_row(table, "1", "2", "3", "4", "5", "6", "7", "8");
        create_row(table, "16", " ", " ", "", "", "", "", "");
        create_row(table, "17", " ", " ", "", "", "", "", "");
        create_row(table, "18", " ", " ", "", "", "", "", "");
        create_row(table, "19", " ", " ", "", "", "", "", "");
        create_row(table, "20", " ", " ", "", "", "", "", "");
        create_row(table, "21", " ", " ", "", "", "", "", "");
        create_row(table, "22", " ", " ", "", "", "", "", "");
        create_row(table, "23", " ", " ", "", "", "", "", "");
        create_row(table, "24", " ", " ", "", "", "", "", "");
        create_row(table, "25", " ", " ", "", "", "", "", "");
        create_row(table, "26", " ", " ", "", "", "", "", "");
        create_row(table, "27", " ", " ", "", "", "", "", "");
        create_row(table, "28", " ", " ", "", "", "", "", "");
        create_row(table, "29", " ", " ", "", "", "", "", "");
        create_row(table, "30", " ", " ", "", "", "", "", "");

        return table;
    }

    public static PdfPTable getPdfPTable3() throws DocumentException{
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1f,1f,1f,1f,1f});

        getPdfPCell(table, "ВСЬОГО ОЦІНОК", medium, true, 2, false, 0);
        getPdfPCell(table, "СУМА БАЛІВ", medium, true, 2, false, 0);
        getPdfPCell(table, "ОЦІНКА ECTS", medium, true, 2, false, 0);
        getPdfPCell(table, "ОЦІНКА ЗА НАЦІОНАЛЬНОЮ ШКАЛОЮ", medium, false, 0, true, 2);

        getPdfPCell(table, "екзамен", mediumBold, false, 0, false, 0);
        getPdfPCell(table, "залік", mediumBold, false, 0, false, 0);

        getPdfPCell(table, "", medium, false, 0, false, 0);
        getPdfPCell(table, "90-100", medium, false, 0, false, 0);
        getPdfPCell(table, "A", medium, false, 0, false, 0);
        getPdfPCell(table, "відмінно", medium, false, 0, false, 0);
        getPdfPCell(table, "зараховано", medium, true, 5, false, 0);

        getPdfPCell(table, "", medium, false, 0, false, 0);
        getPdfPCell(table, "82-89", medium, false, 0, false, 0);
        getPdfPCell(table, "B", medium, false, 0, false, 0);
        getPdfPCell(table, "добре", medium, true, 2, false, 0);

        getPdfPCell(table, "", medium, false, 0, false, 0);
        getPdfPCell(table, "74-81", medium, false, 0, false, 0);
        getPdfPCell(table, "C", medium, false, 0, false, 0);

        getPdfPCell(table, "", medium, false, 0, false, 0);
        getPdfPCell(table, "64-73", medium, false, 0, false, 0);
        getPdfPCell(table, "D", medium, false, 0, false, 0);
        getPdfPCell(table, "задовільно", medium, true, 2, false, 0);

        getPdfPCell(table, "", medium, false, 0, false, 0);
        getPdfPCell(table, "60-63", medium, false, 0, false, 0);
        getPdfPCell(table, "E", medium, false, 0, false, 0);

        getPdfPCell(table, "", medium, false, 0, false, 0);
        getPdfPCell(table, "35-59", medium, false, 0, false, 0);
        getPdfPCell(table, "FX", medium, false, 0, false, 0);
        getPdfPCell(table, "незадовільно", medium, true, 2, false, 0);
        getPdfPCell(table, "незараховано", medium, true, 2, false, 0);

        getPdfPCell(table, "", medium, false, 0, false, 0);
        getPdfPCell(table, "1-34", medium, false, 0, false, 0);
        getPdfPCell(table, "F", medium, false, 0, false, 0);

        return table;
    }

    private static void create_row(PdfPTable table, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8){
        getPdfPCell(table, text1, medium, false, 0, false, 0);
        getPdfPCell(table, text2, medium, false, 0, false, 0);
        getPdfPCell(table, text3, medium, false, 0, false, 0);
        getPdfPCell(table, text4, medium, false, 0, false, 0);
        getPdfPCell(table, text5, medium, false, 0, false, 0);
        getPdfPCell(table, text6, medium, false, 0, false, 0);
        getPdfPCell(table, text7, medium, false, 0, false, 0);
        getPdfPCell(table, text8, medium, false, 0, false, 0);
    }



    private static void addEmptyLine(Paragraph paragraph) {
        for (int i = 0; i < 1; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private static int calculateTextWidthInPixels(String text, int fontSize, BaseFont baseFont) {
        return (int) (baseFont.getWidthPoint(text, fontSize) * (72f / 96f)); // Convert points to pixels (1 point = 1/72 inch)
    }










}
