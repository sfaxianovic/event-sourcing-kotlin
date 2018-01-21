package sfx

import org.springframework.beans.factory.annotation.Autowired

class Account(initialBalance: Double, private var accountId: AccountId) {
    @Autowired
    private lateinit var accountService: AccountService
    private var balance: Double

    init {
        balance  = initialBalance
    }
    fun deposit(amount: Double) {
        balance += amount
    }

    fun getBalance(): Double {
        return balance;
    }

    fun withdraw(amount: Double) {
        if (balance < amount) {
            throw BalanceInsuffisantException("your balance is insuffisant")
        }
        else {
            balance -= amount
        }
    }
}

class AccountId(id: String) {

}

class BalanceInsuffisantException(message: String) : Throwable() {

}
