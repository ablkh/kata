package bank.model

import bank.messages.Messages

final case class PositifNumber private(_value: BigDecimal) {
  def value: BigDecimal = _value
}

object PositifNumber {

  def apply(value: BigDecimal): PositifNumber = {
    assume(value >= 0, Messages.ERROR_NEGATIVE_VALUE)
    new PositifNumber(value)
  }

  implicit def positifNumber2Double(value: PositifNumber): BigDecimal = value.value

}
