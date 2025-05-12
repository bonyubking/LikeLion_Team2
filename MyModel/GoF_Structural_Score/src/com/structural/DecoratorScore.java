package com.structural;

interface ReportComponent {
    String getReport();
}

class BaseScore implements ReportComponent {
    private int kor, eng, mat;

    public BaseScore(int kor, int eng, int mat) {
    }

    @Override
    public String getReport() {
        int tot = kor + eng + mat;
        double avg = tot / 3.0;
        return "총점 : " + tot + "평균 : " + avg;
    }
}

// 기능 추가
public class DecoratorScore implements ReportComponent {
    protected ReportComponent reportComponent;

    public DecoratorScore(ReportComponent reportComponen) {
        this.reportComponent = reportComponent;
    }

    @Override
    public String getReport() {
        return "";
    }
}

// 생성자 만들고 등급 추가
class GradeDecorator extends DecoratorScore {
    public GradeDecorator(ReportComponent reportComponent) {
        super(reportComponent);
    }

    @Override
    public String getReport() {
        return reportComponent.getReport() + " 등급 : "+"A";
    }
}
