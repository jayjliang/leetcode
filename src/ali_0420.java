import NewCoder.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by LiangJ on 2016/4/20.
 */
public class ali_0420 {
    public static void main(String[] args){
        File file = new File("F:\\test.txt");
        try {
            FileInputStream fs = new FileInputStream(file);

            System.out.println(file.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(file.getUsableSpace());
    }
    public int func()
    {
        int count = 0;
        int num = 12345;
        while (num>0)
        {
            count++;
            num &= (num - 1);
        }
        System.out.println(count);
        return count;
    }
    class discount {
        int type;
        int price;
        int sum;
        public discount(int type,int sum,int price){
            this.type = type;
            this.sum=sum;
            this.price = price;
        }
        public int getType(){
            return type;
        }
        public int getPrice(){
            return price;
        }
        public int getSum(){
            return sum;
        }
    }
    /*
    参数：
        sum:商品总价格
        sum_of_by:包邮最低总价格
        price_of_by:包邮优惠价格
        num_type:红包优惠满减价格数组
        num_price:红包优惠满减优惠价格数组
    返回:
        最优价格对象
     */

    public discount soultion(int sum,int sum_of_by,int price_of_by,int[] num_type,int[] num_price){
        int result_type=0;
        int result_price=0;
        int by_is_ok=0;
        int by_price=0;
        int discount_is_ok=0;
        int discount_price=0;
        int discount_sum=0;
        if(sum>sum_of_by){
            by_is_ok = 1;
            by_price=price_of_by;
        }
        for(int i=num_type.length-1;i>0;i--){
            if(sum>=num_type[i]){
                discount_is_ok=0;
                discount_sum=num_type[i];
                discount_price=num_price[i];
                break;
            }
        }
        discount discount;
        if(discount_price>by_price){
            discount=new discount(0,discount_sum,discount_price);
        } else {
            discount=new discount(1,sum_of_by,by_price);
        }
        return discount;
    }

}



/*
操作结果信息类
 */
class Message{
    String error_reason;
    boolean result;
    private volatile static Message message = null;
    public static Message getMessage(){
        if(message==null){
            synchronized (Message.class){
                if(message==null){
                    message = new Message();
                }
            }
        }
        return message;
    }
    public Message(){

    }
    public void setError_reason(String reason){
        message.error_reason = reason;
    }
    public void setResult(boolean result){
        message.result = result;
    }
}
//转账接口
interface transfer {
    Message operation(String account_out,String account_in,double money);
}
//转账操作类
class transfer_class implements transfer{
    private Message message=Message.getMessage();
    public transfer_class(){

    }
    public synchronized Message operation(String account_out,String account_in,double money){
        if(check_account(account_out)||check_account(account_in)){
            message.setResult(false);
            message.setError_reason("账户不合法");
        } else {
            account ac_in = new account(account_in);
            account ac_out = new account(account_out);
            if(ac_out.getBalance()<money){
                message.setResult(false);
                message.setError_reason("账户余额不足");
            } else {
                double money_in = ac_in.getBalance();
                double money_out = ac_out.getBalance();
                try{
                    if(ac_out.money_out(money)){
                        ac_in.money_in(money);
                    };
                    message.setResult(true);
                    message.setError_reason("操作成功");
                } catch (Exception e){
                    if(ac_out.getBalance()!=money_out){
                        ac_out.money_in(money);
                    }
                    if(ac_in.getBalance()!=money_in){
                        ac_in.money_out(money);
                    }
                    message.setResult(false);
                    message.setError_reason("系统错误");
                }

            }
        }
        return message;
    }
    /*
    检验账号是否合法
     */
    private boolean check_account(String accound_id){
        /*
        to do
         */
        return true;
    }

}
//个人账户类
class account{
    private String account_id;
    private  double balance=0;
    public account(String account_id){
        this.account_id = account_id;
    }
    public double getBalance(){
        return balance;
    }
    public synchronized boolean setBalance(double balance){
        try{
            balance = balance;
            return true;
        } catch (Exception e){
            return false;
        } finally {
            return false;
        }

    }
    //转入
    public synchronized boolean money_in(double money){
        try{
            balance += money;
            return true;
        } catch (Exception e){
            return false;
        } finally {
            return false;
        }

    }
    //转出
    public synchronized boolean money_out(double money){
        try{
            balance -= money;
            return true;
        } catch (Exception e){
            return false;
        } finally {
            return false;
        }

    }

}
/*
问题2：
在这种情况下，个人转账接口会难以处理，因为需要淘宝担保交易的介入，且买家对货满意是有很多天延迟的甚至更久，此时这个接口以及没有办法满足要求
解决方案：
可以采用aop编程思想，增加淘宝担保交易中间层
淘宝担保交易中间层可以进行转账交易，向用户已经商家提供接口
在接收到买家卖货资金时，存入淘宝担保账号，并且做相应记录，当买家收到货满意进行确认收货或者超过时间
淘宝担保账号将现金转入买家账号


优惠券是目前较为受用户欢迎的促销手段，为了方便用户使用优惠券，网站在用户提交购买购物车中的商品时自动为用户推荐并使用最合适的优惠券。目前假设有两类优惠券：
1、“满包邮”：即在单一店铺中购买商品总价满足一定条件时会减免用户的快递费用，例如：满100包邮
2、“红包”：即单一店铺中购买商品总价满足一定条件时会产生一定程度的金额减免，例如：满100减10、满300减20等
请就如上设定，设计购物车提交时优惠券的推荐程序，规定每个店铺只能使用一张优惠券。
问题1：请阐述你的设计方案，形式不限
问题2：请用Java实现推荐程序，代码范围限定使用JDK原生API
 */