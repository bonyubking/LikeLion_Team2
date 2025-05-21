package com.structural;

interface ReportComponet {
	String getReport();
}

class BaseScore implements ReportComponet {
	private int kor, eng, mat;

	public BaseScore(int kor, int eng, int mat) {

	}

	@Override
	public String getReport() {
		int tot = kor + eng + mat;
		double avg = tot / 3.0;
		return "총점 :" + tot + "평균: " + avg;
	}
}

// 기능 추가  
public class DecoratorScore implements ReportComponet {
	protected ReportComponet component;

	public DecoratorScore(ReportComponet component) {
		super();
		this.component = component;
	}

	@Override
	public String getReport() {
		return "";
	}
}

//생성자 만들고 등급 추가하자.  
class GradeDecorator extends DecoratorScore {

	public GradeDecorator(ReportComponet component) {
		super(component);
	}

	@Override
	public String getReport() {
		return component.getReport() + "  등급 :" + "A";
	}
}
