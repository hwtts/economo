package hwtts.economo;

/**
 * Created by Administrator on 02.08.2015.
 */
public class Calculator {
    String result;
    int maxTime;
    public Calculator() {
        result = "";
    }
    public Calculator(int maxTime) {
        result = "";
        this.maxTime = maxTime;
    }

    public void showResult() {

    }
    public String doAll() {

        return result;
    }


    public String doCredit(double neededSum, double requiredMoney, double possiblePay, double sumAllComissions, double persentageCredit) {
        int time = 1;
        double moneyWithoutComissions = possiblePay - possiblePay * sumAllComissions;
        double payForBank = neededSum * (persentageCredit +  (persentageCredit /  (Math.pow(1 + persentageCredit, time)-1)));
        while ((time <= 1200)&(moneyWithoutComissions <= payForBank)) {
            time++;
            payForBank = neededSum * (persentageCredit +  (persentageCredit /  (Math.pow(1 + persentageCredit, time)-1)));
        }
        if (time > 1200) {
            result = "Кредит невозможен. Слишком большой срок.";
        } else {
            result = "Кредит возможен на следующих условиях.";
            double overpayments = payForBank * time - (neededSum - requiredMoney);
        }
        return result;
    }

    public String doSaveUp(double neededSum, double requiredMoney,double possiblePay, double inflation) {
        int time = 0;
        while ((neededSum >= requiredMoney)&(time <= 1200)) {
            time++;
            neededSum = neededSum + neededSum * inflation;
            requiredMoney = requiredMoney + possiblePay;
        }
        if (time > 1200) {
            result = "Личное накопление невозможно. Слишком большой срок.";
        } else {
            result = "Личное накопление возможно на следующих условиях";
        }
        return result;
    }

    public String doDeposit(double neededSum, double requiredMoney,double possiblePay, double inflation, double persentageDeposit) {
        int time = 0;
        requiredMoney = requiredMoney + possiblePay;
        while ((neededSum >= requiredMoney)&(time <= 1200)) {
            time++;
            neededSum = neededSum + neededSum * inflation;
            requiredMoney = requiredMoney + requiredMoney*persentageDeposit;
        }
        if (time > 1200) {
            result = "Вклад в банк невозможен. Слишком большой срок";
        } else {
            result = "Вклад возможен на следующих условиях";
        }
        return result;

    }
}
