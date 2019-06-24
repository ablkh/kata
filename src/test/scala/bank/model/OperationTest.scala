package bank.model

import java.util.Calendar

import bank.model.Operation.{Deposit, Withdrawal}
import org.scalatest.{Matchers, WordSpec}

class OperationTest extends WordSpec with Matchers{

  private val VALUE = PositifNumber(10)
  private val DATE = Calendar.getInstance.getTime
  private val BALANCE = -1.0
  private val DEPOSIT_STRING = s"Deposit( value => $VALUE ; date => $DATE; balance before operation => $BALANCE )"
  private val WITHDRAWAL_STRING = s"Withdrawal( value => $VALUE ; date => $DATE; balance before operation => $BALANCE )"

  "Depot" when {
    "instancier" should {
      "a une method toString detailler" in {
        val depot = Deposit(VALUE, BALANCE, DATE)
        depot.toString shouldBe DEPOSIT_STRING
      }
    }
  }

  "Retrait" when {
    "instancier" should {
      "a une method toString detailler" in {
        val retrait = Withdrawal(VALUE, BALANCE, DATE)
        retrait.toString shouldBe WITHDRAWAL_STRING
      }
    }
  }


}
