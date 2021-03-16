package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class describes how the bank works with users and their accounts
 *
 * @author - Sergey Kalenikov
 * @version 1.0
 */
public class BankService {
    /**
     * User accounts are stored in a HashMap collection
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * This method adds the user to the system
     *
     * @param user instance of the user class
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * This method adds a user account
     *
     * @param passport passport string
     * @param account  instance of the account class
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * This method searches for a user by passport
     *
     * @param passport passport string
     * @return instance of the user class or null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * This method searches for a user`s account by requisite
     *
     * @param passport  passport string
     * @param requisite requisite string
     * @return instance of the account class or null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * This method transfers funds between user accounts
     *
     * @param srcPassport   source passport string
     * @param srcRequisite  source requisite string
     * @param destPassport  destination passport string
     * @param destRequisite destination requisite string
     * @param amount        amount of funds
     * @return false if some account was not found, true if transfers success
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account dstAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null
                || dstAccount == null
                || srcAccount.getBalance() < amount) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        dstAccount.setBalance(dstAccount.getBalance() + amount);
        return true;
    }
}