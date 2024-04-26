/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package informantdb;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import informantdb.User;
import informantdb.Ads;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class InformantDB {

    static protected EntityManagerFactory factory = Persistence.createEntityManagerFactory("informantDBPU");
    static protected EntityManager manager = factory.createEntityManager();
    static protected EntityTransaction transaction = manager.getTransaction();

    static public String SignIn(UserInput user, String token) throws InterruptedException {
        try {
            if (user != null) {
                Query q = manager.createNamedQuery("User.findByName", User.class);
                q.setParameter("name", user.UserName);
                userBaseData addedUser = new userBaseData((User) q.getSingleResult());
                if (addedUser == null) {
                    System.out.println("NOT FOUND");
                    return "Error::NOt found";
                } else if (addedUser.currentUser.getPassword().equals(user.Password)) {
                    String userToken = TokenProducer.produce();
                    users.put(userToken, addedUser); //defualt one
                    if (token != null) {
                        try {
                            if (users.get(token) != null) {
                                users.remove(token);
                            }
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    addedUser.currentUser.setToken(userToken);
                    System.out.println(addedUser.currentUser);
                    try {
                        transaction.begin();
                        manager.merge(addedUser.currentUser);
                        transaction.commit();
                    } catch (Exception ex) {
                        if (transaction.isActive()) {
                            transaction.rollback();
                        }
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("New Token: " + userToken);
                    return userToken;
                }
            } else if (token != null) {
                Query q = manager.createNamedQuery("User.findByToken");
                var currentUser = new User();
                if (!users.isEmpty()) {
                    try {
                        if (users.get(token) != null) {
                            currentUser = users.get(token).currentUser;
                        }
                    } catch (Exception ex) {
                        System.out.println("BAD REQUEST: " + ex.getMessage());
                        return "Error::BAD REQUEST: " + ex.getMessage();
                    }
                }
                if (currentUser == null) {
                    currentUser = (User) q.getSingleResult();
                }
                var userToken = TokenProducer.produce();
                if (currentUser == null) {
                    System.out.println("USER NOT EXIST");
                    return "Error::USER NOT EXIST";
                } else {
                    currentUser.setToken(userToken);
                    users.remove(token);
                    users.put(userToken, new userBaseData(currentUser));
                    try {
                        transaction.begin();
                        manager.merge(currentUser);
                        transaction.commit();
                    } catch (Exception ex) {
                        if (transaction.isActive()) {
                            transaction.rollback();
                        }
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("NEW TOKEN: " + userToken);
                    return userToken;
                }
            }
            System.out.println("BAD REQUEST NO PARAMETERS PROVIDED OR FAILD TO SING-IN");
            return "Error::BAD REQUEST NO PARAMETERS PROVIDED";
        } catch (Exception ex) {
            System.out.println("BAD REQUEST " + ex.getMessage());
            return "Error::BAD REQUEST " + ex.getMessage();
        }
    }

    static public void createUser(createUser user1) {
        User u = new User();
        u.setName(user1.username);
        u.setPassword(user1.password);
        u.setDetails(user1.details);
        u.setEmail(user1.email);
        u.setCridetCard(user1.creditCard);
        transaction.begin();
        manager.persist(u);
        transaction.commit();
    }

    static HashMap<String, userBaseData> users = new HashMap<String, userBaseData>();
    static ArrayList<Ads> adList = new ArrayList<Ads>();

    static public void Command(String command) throws InterruptedException {
        Scanner u = new Scanner(System.in);
        if (command.contains("q:ch")) {
            System.out.println("Please sign in first: ");
            System.out.print("Enter UserName: ");
            String username = u.nextLine();
            System.out.print("Enter Password: ");
            String password = u.nextLine();
            var signINUser = new UserInput(username, password);
            var token = SignIn(signINUser, null);
            if (!token.contains("Error::")) {
                User signedInUser = users.get(token).currentUser;
                System.out.println("DETAILS :: " + signedInUser);
                System.out.print("Enter what you data you change: ");
                String tempS = u.nextLine();
                transaction.begin();

                if (tempS.toLowerCase().contains("email")) {
                    System.out.print("Email: ");
                    String t = u.nextLine();
                    signedInUser.setEmail(t);
                } else if (tempS.toLowerCase().contains("password")) {
                    System.out.print("password: ");
                    String t = u.nextLine();
                    signedInUser.setPassword(t);
                } else if (tempS.toLowerCase().contains("name")) {
                    createUser createdUser = new createUser();
                    Query q = manager.createNamedQuery("User.findByName", User.class);
                    do {
                        System.out.print("UserName: ");
                        createdUser.username = u.nextLine();
                        q.setParameter("name", createdUser.username);
                        User li = null;
                        try {
                            li = (User) q.getSingleResult();
                        } catch (Exception ex) {
                        }
                        if (li == null) {
                            break;
                        }
                        System.out.println("The name already exist");
                    } while (true);
                } else if (tempS.toLowerCase().contains("cridet")) {
                    System.out.print("cridet Card Number: ");
                    String t = u.nextLine();
                    signedInUser.setCridetCard(t);
                } else if (tempS.toLowerCase().contains("token") || tempS.toLowerCase().contains("id")) {
                    System.out.print("Not allowed action");
                    return;
                }
                manager.merge(signedInUser);
                transaction.commit();
            } else {
                System.out.println(token);
            }
        } else if (command.contains(
                "q:up")) {
            System.out.println("Please Enter the following data:");
            createUser createdUser = new createUser();
            Query q = manager.createNamedQuery("User.findByName", User.class);
            do {
                System.out.print("UserName: ");
                createdUser.username = u.nextLine();
                q.setParameter("name", createdUser.username);
                User li = null;
                try {
                    li = (User) q.getSingleResult();
                } catch (Exception ex) {
                }
                if (li == null) {
                    break;
                }
                System.out.println("The name already exist");
            } while (true);
            System.out.print("Password: ");
            createdUser.password = u.nextLine();
            System.out.print("Email: ");
            createdUser.email = u.nextLine();
            System.out.print("Details: ");
            createdUser.details = u.nextLine();
            System.out.print("credit Card: ");
            createdUser.creditCard = u.nextLine();
            createUser(createdUser);
        } else if (command.toLowerCase().contains(
                "q:tk")) {
            System.out.print("Enter Token: ");
            SignIn(null, u.nextLine());

        } else if (command.toLowerCase().contains(
                "q:in")) {

            System.out.print("Enter UserName: ");
            String username = u.nextLine();
            System.out.print("Enter Password: ");
            String password = u.nextLine();
            var signINUser = new UserInput(username, password);
            var tokenOrError = SignIn(signINUser, null);
            if(!tokenOrError.contains("Error")){
                AfterSignIn(tokenOrError);
            }
        }
    }

    ///omar
    static public String insert(IAd i, User uu) {
        Ads ad = new Ads();
        ad.setStars(i.getStars());
        ad.setPrice(i.getPrice());
        ad.setDetails(i.getDetails());
        try {
            ad.setCreatorID(uu);
            Query q = manager.createNamedQuery("Images.findById", Images.class);
            if (-1 != i.getImageId()) {
                q.setParameter("id", i.getImageId());
                Images ii = (Images) q.getSingleResult();
                ad.setImageId(ii);
            }else{ad.setImageId(null);}
            q = manager.createNamedQuery("Payment.findById", Payment.class);
            q.setParameter("id", i.getPaymentId());
            Payment pp = (Payment) q.getSingleResult();
            ad.setPaymentId(pp);
        } catch (Exception ex) {
            return "Error::Something went Wrong" + ex.getMessage();
        }

        try {
            transaction.begin();
            manager.persist(ad);
            transaction.commit();
            return "AD ADDED SUCCESSFULLY";
        } catch (Exception ex) {
            return "Error::" + ex.getMessage();
        }
    }
    ///omar

    static public void AfterSignIn(String Token) {
        System.out.print("Enter Query:\nq:create - create new ad: ");
        Scanner u = new Scanner(System.in);
        u.nextLine();
        IAd iad = new IAd();
        System.out.print("set Price: ");
        iad.setPrice(u.nextFloat());
        u.nextLine();
        System.out.print("insert ad Details: ");
        iad.setDetails(u.nextLine());
        iad.setImageId(-1L);
        iad.setPaymentId(3);
        var mes = insert(iad,users.get(Token).currentUser);
        System.out.println(mes);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
//        EntityManager DB = createEntityManager("informantDBPU");
        do {

            System.out.println("Enter Command: ");
            System.out.println("q:In - sign in user");
            System.out.println("q:Up - sign up user");
            System.out.println("q:tK - sign in user with token ");
            System.out.println("q:ch - change user data ");
            System.out.println("q:E - Exit ");
            System.out.print("Enter Command (\"don't forget ((q:)) before the query\"): ");
            Scanner c = new Scanner(System.in);
            String ss = c.nextLine();
            Command(ss);
            if (ss.toLowerCase().contains("q:e")) {
                break;
            }
        } while (true);
        manager.close();
        factory.close();

    }

}