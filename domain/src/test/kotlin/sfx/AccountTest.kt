package sfx

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import java.util.*
import kotlin.test.assertEquals

class AccountSpek: Spek({
    given("an Account") {
        val account = Account(0.0, AccountId(UUID.randomUUID().toString()))
        on("deposit") {
          account.deposit(50.0)
            it("should increase balance by 50") {
              assertEquals(50.0, account.getBalance())
            }
        }
        on("withdraw") {
            account.deposit(50.0)
            account.withdraw(40.0)
            it("should throw balance insuffisant") {
                assertEquals(60.0, account.getBalance())
            }
        }
    }
})