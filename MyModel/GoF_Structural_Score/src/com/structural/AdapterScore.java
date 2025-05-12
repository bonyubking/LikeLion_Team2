package com.structural;

// Legacy System
class OldScoreSystem {
    public int getSum() {
        return 270;
    }

    public double getAvg() {
        return 90.0;
    }

}

// Adapter : 기존의 시스템을 현재 시스템 객체로 만들어 사용
class AdapterScore extends Score {
    private OldScoreSystem oldScoreSystem;

    public AdapterScore(OldScoreSystem oldScoreSystem) {
        super(0, 0, 0);
        this.oldScoreSystem = oldScoreSystem;
    }

    @Override
    public int getTotal() {
        return oldScoreSystem.getSum();
    }

    @Override
    public double getAverage() {
        return oldScoreSystem.getAvg();
    }
}


