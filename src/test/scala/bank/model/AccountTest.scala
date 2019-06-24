package bank.model

import java.util.Calendar

import bank.model.Operation.{Deposit, Withdrawal}
import org.scalatest.{Matchers, WordSpec}

class AccountTest extends WordSpec with Matchers {

  private val INITIAL_BALANCE = 0
  private val VALUE_OPERATION = 10
  private val DATE_OPERATION = Calendar.getInstance.getTime

  "Un compte" when {

    "qui vient d'etre creer" should {
      "doit avoir une valeur de zero et un historique vide" in {
        val account = Account()
        account.somme shouldBe INITIAL_BALANCE
        account.history shouldBe List.empty
      }
    }

    "qui vient d'effectuer un depot" should {
      "doit avoir une nouvelle somme et un historique du depot effectuer" in {
        val accountAFterDeposit = Account().deposit(PositifNumber(VALUE_OPERATION), DATE_OPERATION)
        accountAFterDeposit.somme shouldBe VALUE_OPERATION
        accountAFterDeposit.history shouldBe List(Deposit(PositifNumber(VALUE_OPERATION), INITIAL_BALANCE, DATE_OPERATION))
      }
    }

    "qui vient d'effectuer un retrait" should {
      "doit avoir une nouvelle somme(qui peut etre negatif) et un historique du retrait effectuer" in {
        val accountAFterWithdrawal = Account().withdrawal(PositifNumber(VALUE_OPERATION), DATE_OPERATION)
        accountAFterWithdrawal.somme shouldBe Math.negateExact(VALUE_OPERATION)
        accountAFterWithdrawal.history shouldBe List(Withdrawal(PositifNumber(VALUE_OPERATION), INITIAL_BALANCE, DATE_OPERATION))
      }
    }

    "et un autres compte" should {
      "ne doivent pas avoir le meme bankId" in {
        Account().bankId should not be Account().bankId
      }
    }

    "avec des operations flotante" should {
      "ne doit pas etre en ecart" in {
        val val1 = 0.1
        val val2 = 0.2
        Account().deposit(PositifNumber(val1)).deposit(PositifNumber(val2)).somme shouldBe 0.3
      }
    }


  }


}
