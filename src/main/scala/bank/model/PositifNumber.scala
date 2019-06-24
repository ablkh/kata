package bank.model

import bank.messages.Messages

final case class PositifNumber private(_value: Double) {
  def value: Double = _value
}

object PositifNumber {

  def apply(value: Double): PositifNumber = {
    assume(value >= 0, Messages.ERROR_NEGATIVE_VALUE)
    new PositifNumber(value)
  }

  implicit def positifNumber2Double(value: PositifNumber): Double = value.value

}
