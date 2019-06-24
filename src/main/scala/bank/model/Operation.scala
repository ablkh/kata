package bank.model

import java.util.Date

sealed abstract class Operation(value: PositifNumber, balanceBeforeOp: BigDecimal, date: Date) {
  override def toString: String = s"value => $value ; date => $date; balance before operation => $balanceBeforeOp"
}


object Operation {

  case class Withdrawal(value: PositifNumber,
                        balanceBeforeOp: BigDecimal,
                        date: Date) extends Operation(value, balanceBeforeOp, date) {

    override def toString: String = s"Withdrawal( ${super.toString} )"

  }

  case class Deposit(value: PositifNumber,
                     balanceBeforeOp: BigDecimal,
                     date: Date) extends Operation(value, balanceBeforeOp, date) {

    override def toString: String = s"Deposit( ${super.toString} )"

  }

}


