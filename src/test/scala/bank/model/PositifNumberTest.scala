package bank.model

import org.scalatest.{Matchers, WordSpec}

class PositifNumberTest extends WordSpec with Matchers {

  "PositifNumber" when {
    "constructeur" should {
      "ne peut accepter de valeur negatif" in {
        assertThrows[AssertionError] {
          PositifNumber(-1)
        }
      }

      "accepte la valeur zero" in {
        PositifNumber(0).value shouldBe 0
      }

      "accepte les valeurs positif" in {
        PositifNumber(100).value shouldBe 100
        PositifNumber(24).value shouldBe 24
      }

    }
  }



}
