package bank.model

import java.util.Calendar

import bank.model.Operation.{Deposit, Withdrawal}
import org.scalatest.{Matchers, WordSpec}

class CompteTest extends WordSpec with Matchers {

  private val INITIAL_BALANCE = 0
  private val VALUE_OPERATION = 10
  private val DATE_OPERATION = Calendar.getInstance.getTime

  "Un compte" when {

    "qui vient d'etre creer" should {
      "doit avoir une valuer de zero et un historique vide" in {
        val compte = Compte()
        compte.somme shouldBe INITIAL_BALANCE
        compte.history shouldBe List.empty
      }
    }

    "qui vient d'effectuer un depot" should {
      "doit avoir une nouvelle somme et un historique du depot effectuer" in {
        val compteAFterDepot = Compte().depot(PositifNumber(VALUE_OPERATION), DATE_OPERATION)
        compteAFterDepot.somme shouldBe VALUE_OPERATION
        compteAFterDepot.history shouldBe List(Deposit(PositifNumber(VALUE_OPERATION), INITIAL_BALANCE, DATE_OPERATION))
      }
    }

    "qui vient d'effectuer un retrait" should {
      "doit avoir une nouvelle somme(qui peut etre negatif) et un historique du retrait effectuer" in {
        val compteAFterDepot = Compte().retry(PositifNumber(VALUE_OPERATION), DATE_OPERATION)
        compteAFterDepot.somme shouldBe Math.negateExact(VALUE_OPERATION)
        compteAFterDepot.history shouldBe List(Withdrawal(PositifNumber(VALUE_OPERATION), INITIAL_BALANCE, DATE_OPERATION))
      }
    }

    "et un autres compte" should {
      "ne doivent pas avoir le meme bankId" in {
        Compte().bankId should not be Compte().bankId
      }
    }




  }


}
