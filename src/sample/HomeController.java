package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static sample.LoginController.currentUser;

/**
 * Created by ASHUTOSH on 04-Nov-16.
 */
public class HomeController {

    @FXML
    Label username,n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,total,area,status;
    @FXML
    Label cn1,cn2,cn3,cn4,cn5,cn6,cn7,cn8,cn9,cn10,ci1,ci2,ci3,ci4,ci5,ci6,ci7,ci8,ci9,ci10,cp1,cp2,cp3,cp4,cp5,cp6,cp7,cp8,cp9,cp10;
    @FXML
    Label cq1,cq2,cq3,cq4,cq5,cq6,cq7,cq8,cq9,cq10;
    @FXML
    TextField cname,mob,address,cno,cvv,pin;
    @FXML
    ImageView signout,back,mycart,additems,removeitems,checkout;
    @FXML
    TextField q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
    @FXML
    Button a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,paybtn;

    String iname;
    int ino,price,quantity,n,sum;

    public void showUser()
    {
        username.setText(currentUser);
    }

    public void add(ActionEvent event) throws IOException
    {
        if (event.getSource() == a1) {
            ino = Integer.valueOf(n1.getText());iname = i1.getText();price = Integer.valueOf(p1.getText());quantity = Integer.valueOf(q1.getText());
        }
        else if (event.getSource() == a2) {
            ino = Integer.valueOf(n2.getText());iname = i2.getText();price = Integer.valueOf(p2.getText());quantity = Integer.valueOf(q2.getText());
        }
        else if (event.getSource() == a3) {
            ino = Integer.valueOf(n3.getText());iname = i3.getText();price = Integer.valueOf(p3.getText());quantity = Integer.valueOf(q3.getText());
        }
        else if (event.getSource() == a4) {
            ino = Integer.valueOf(n4.getText());iname = i4.getText();price = Integer.valueOf(p4.getText());quantity = Integer.valueOf(q4.getText());
        }
        else if (event.getSource() == a5) {
            ino = Integer.valueOf(n5.getText());iname = i5.getText();price = Integer.valueOf(p5.getText());quantity = Integer.valueOf(q5.getText());
        }
        else if (event.getSource() == a6) {
            ino = Integer.valueOf(n6.getText());iname = i6.getText();price = Integer.valueOf(p6.getText());quantity = Integer.valueOf(q6.getText());
        }
        else if (event.getSource() == a7) {
            ino = Integer.valueOf(n7.getText());iname = i7.getText();price = Integer.valueOf(p7.getText());quantity = Integer.valueOf(q7.getText());
        }
        else if (event.getSource() == a8) {
            ino = Integer.valueOf(n8.getText());iname = i8.getText();price = Integer.valueOf(p8.getText());quantity = Integer.valueOf(q8.getText());
        }
        else if (event.getSource() == a9) {
            ino = Integer.valueOf(n9.getText());iname = i9.getText();price = Integer.valueOf(p9.getText());quantity = Integer.valueOf(q9.getText());
        }
        else if (event.getSource() == a10) {
            ino = Integer.valueOf(n10.getText());iname = i10.getText();price = Integer.valueOf(p10.getText());quantity = Integer.valueOf(q10.getText());
        }
        else if (event.getSource() == a1) {
            ino = Integer.valueOf(n1.getText());iname = i1.getText();price = Integer.valueOf(p1.getText());quantity = Integer.valueOf(q1.getText());
        }

        try {
            Connection con = SqliteConnection.Connector();
            Statement stmt;
            if (con != null)
            {
                stmt = con.createStatement();
                String sql = "INSERT INTO cart VALUES ('"+ino+"','"+iname+"','"+price+"','"+quantity+"','"+currentUser+"')";
                stmt.executeUpdate(sql);
                con.commit();
                stmt.close();
                con.close();
            }

        }
        catch (Exception e){}

    }

    public void remove(ActionEvent event) throws IOException
    {
        if (event.getSource() == r1) {
            n = Integer.valueOf(n1.getText());
        }
        else if (event.getSource() == r2) {
            n = Integer.valueOf(n2.getText());
        }
        else if (event.getSource() == r3) {
            n = Integer.valueOf(n3.getText());
        }
        else if (event.getSource() == r4) {
            n = Integer.valueOf(n4.getText());
        }
        else if (event.getSource() == r5) {
            n = Integer.valueOf(n5.getText());
        }
        else if (event.getSource() == r6) {
            n = Integer.valueOf(n6.getText());
        }
        else if (event.getSource() == r7) {
            n = Integer.valueOf(n7.getText());
        }
        else if (event.getSource() == r8) {
            n = Integer.valueOf(n8.getText());
        }
        else if (event.getSource() == r9) {
            n = Integer.valueOf(n9.getText());
        }
        else if (event.getSource() == r10) {
            n = Integer.valueOf(n10.getText());
        }

        try {
            Connection con = SqliteConnection.Connector();
            Statement stmt;
            if (con != null)
            {
                stmt = con.createStatement();
                String sql = "DELETE FROM cart WHERE ino = '"+n+"' AND uname = '"+currentUser+"'";
                stmt.executeUpdate(sql);
                con.commit();
                stmt.close();
                con.close();
            }
        }
        catch (Exception e){}
    }

    public void updatePrice() throws IOException
    {
        try {
            Connection con = SqliteConnection.Connector();
            if (con != null) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT SUM(quantity*price) FROM cart WHERE uname = '"+currentUser+"'");
                if (rs.next()) {
                    sum = rs.getInt(1);
                    total.setText(" ₹ "+String.valueOf(sum));
                }
                stmt.close();
                con.close();
            }
        }
        catch (Exception e){}
    }


    public void myCart() throws IOException
    {
        Stage stage;
        Parent root;
        stage=(Stage) mycart.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("view/myCart.fxml"));
        stage.setTitle("Shopping Cart System v1.0 - My Cart");
        stage.setScene(new Scene(root,800,620));
        stage.show();
        stage.setResizable(false);
    }

    public void showCart() throws IOException
    {
        try {
            Connection con = SqliteConnection.Connector();
            if (con != null) {
                Statement stmt = con.createStatement();
                int i=1;
                String s2="";
                ResultSet rs = stmt.executeQuery("SELECT * FROM cart WHERE uname = '"+currentUser+"'");
                s2="\n\tItem No.\t\tItem Name\t\t\tPrice\t\t\tQuantity\n";
                while (rs.next()) {
                    String s = ("\n\t"+rs.getString(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4));
                    area.setText(s2+s);
                    s2 = s2 + s;
                }
                stmt.close();
                con.close();
            }
        }
        catch (Exception e){}
    }

    public void addItems()throws IOException
    {
        Stage stage;
        Parent root;
        stage=(Stage) additems.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("view/items.fxml"));
        stage.setTitle("Shopping Cart System v1.0 - Add/Remove Items");
        stage.setScene(new Scene(root,800,620));
        stage.show();
        stage.setResizable(false);
    }

    public void removeItems()throws IOException
    {
        Stage stage;
        Parent root;
        stage=(Stage) removeitems.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("view/items.fxml"));
        stage.setTitle("Shopping Cart System v1.0 - Add/Remove Items");
        stage.setScene(new Scene(root,800,620));
        stage.show();
        stage.setResizable(false);
    }

    public void Checkout()throws IOException
    {
        Stage stage;
        Parent root;
        stage=(Stage) checkout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("view/checkout.fxml"));
        stage.setTitle("Shopping Cart System v1.0 - Checkout");
        stage.setScene(new Scene(root,800,620));
        stage.show();
        stage.setResizable(false);
    }

    public void payment (ActionEvent event)
    {
        if(event.getSource()==paybtn)
        {
            try {
                if (Integer.valueOf(cvv.getText()) != null && Integer.valueOf(pin.getText()) != null && address.getText() != "" && Integer.valueOf(cno.getText()) != null) {
                    status.setText("... Payment Successfull ...");
                }
            }
            catch (Exception e)
            {
                status.setText("!!! Payment Unsuccessfull !!!\n...Please try again using valid details...");
            }
        }

    }

    public void Back() throws IOException
    {
        Stage stage;
        Parent root;
        stage=(Stage) back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("view/home.fxml"));
        stage.setTitle("Shopping Cart System v1.0 - Home ("+currentUser+")");
        stage.setScene(new Scene(root,800,620));
        stage.show();
        stage.setResizable(false);
    }

    public void logout() throws IOException
    {
        Stage stage;
        Parent root;
        stage=(Stage) signout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        stage.setTitle("Shopping Cart System v1.0");
        stage.setScene(new Scene(root,800,620));
        stage.show();
        stage.setResizable(false);
    }

}
