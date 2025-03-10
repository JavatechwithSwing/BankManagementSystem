import java.util.ArrayList;
import java.util.List;

/*
 * 1.Open Account
 * 2.Debit money
 * 3.Credit money
 * 4.Transfer money
 * 5.check bank balance
 *
 *
 * */

class Info
{
    private String name,mname,sname,pin;
    int accNo;
    double balance;

    public Info(String name, String mname, String sname,String pin, int accNo, double balance) {
        this.name = name;
        this.pin = pin;
        this.accNo = accNo;
        this.balance = balance;
        this.mname = mname;
        this.sname = sname;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMname() {
        return mname;
    }

    public String getSname() {
        return sname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }

    public int getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }
    public double withDraw(double inputBal)
    {
        return balance=balance-inputBal;
    }
    public double deposit(double inputBal)
    {
        return balance = balance + inputBal;
    }

    @Override
    public String toString() {
        return "  " +
                "Name: " + name +" "+ mname+" "+sname+
                "\n            Pin: " + pin  +
                "\n            AccNo: " + accNo +
                "\n            Balance: " + balance ;
    }
}
class Customer
{
    private String pinId;

    public Customer(String pinId)
    {
        this.pinId = pinId;
    }

    public String getPinId() {
        return pinId;
    }
}
class Info_Customer
{
    Info info;
    Customer customer;

    public Info_Customer(Info info, Customer customer) {
        this.info = info;
        this.customer = customer;
    }

    public Info getInfo() {
        return info;
    }

    public Customer getCustomer() {
        return customer;
    }
}
public class Myclass {
    private List<Info> infos = new ArrayList<>();
    private List<Info> Users = new ArrayList<Info>();

    public void addInfo(Info info) {

        infos.add(info);
    }

    public boolean openAcc(String pin)
    {
        for (Info info:infos)
        {
            if (info.getPin().equals(pin))
            {
                return true;
            }
        }
     return Boolean.parseBoolean(null);
    }

    public List<Info> getInfos() {
        return infos;
    }

    public Info getInfoByPin(String pin) {
        for (Info info : infos) {
            if (info.getPin().equals(pin)) {
                return info;
            }
        }
        return null;
    }

    public Info getInfobyDeposit(int Acc, Double am,String pin)
    {
        for (Info info:infos)
        {
            if (info.getAccNo() == Acc && info.getPin().equals(pin))
            {
               // info.deposit(am);
                info.setBalance(info.deposit(am));
                System.out.println(info.getAccNo()+" Balance is = "+info.getBalance());
                return info;

            }
        }
        return null;
    }

    public Info getInfobyWithdraw(int Acc, Double am,String pin)
    {
        for (Info info:infos)
        {
            if (info.getAccNo() == Acc && info.getPin().equals(pin))
            {
                if (info.getBalance()>am)
                {
                    // info.deposit(am);
                    info.setBalance(info.withDraw(am));
                    System.out.println(info.getAccNo()+" Balance is = "+info.getBalance());
                    return info;
                }


            }
        }
        return null;
    }
    public int Count()
    {

        int c = 0;
        for (Info info:infos)
        {
            c++;
        }
        return c;
    }

    public List<Info>  AllDetails()
    {
        List<Info> allInfos = new ArrayList<>();
        for (Info info:infos)
        {
             if (infos.contains(info))
             {
              //   Users.add(info);
                 allInfos.add(info);
             }
          //  return info;


        }
        return allInfos;
    }

    public boolean check(String c)
    {
        for (Info info:infos)
        {
            if (info.getPin().contains(c))
            {
                return true;
            }
        }
        return Boolean.parseBoolean(null);
    }

    public Info changePin(String old,String newpin,String confirmpin)
    {
        boolean c = check(confirmpin);
        if (c == false) {
            for (Info info : infos) {


                if (info.getPin().equals(old)) {
                    if (newpin.equals(confirmpin)) {
                        info.setPin(confirmpin);
                        System.out.println(info.getAccNo() + " pin is successfully changed Pin, Remember new pin: " + info.getPin());
                        return info;

                    } else {
                        System.out.println("Both pins are different");

                    }
                }
            }
        }
        else {
            return null;
        }


        return null;
    }

    public Info transferMoney(int acc,double bal,String pin)
    {
        for (Info info:infos)
        {
            if (info.getPin().equals(pin))
            {
                int tempacc = info.getAccNo();
                if (bal< info.getBalance())
                {
                    if (tempacc != acc)
                    {
                        for (Info info1:infos)
                        {
                            if (info1.getAccNo() == acc)
                            {
                                double amt = info.getBalance()-bal;
                                double am = info1.getBalance()+bal;
                                info.setBalance(amt);
                                info1.setBalance(am);
                                return info;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("both acc no is same!");
                    }
                }
                else
                {
                    System.out.println("Insufficient balance!");
                }

            }
        }

        return null;
    }

}
