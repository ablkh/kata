package bank.model

import java.util.{Calendar, Date, UUID}

import bank.model.Operation.{Deposit, Withdrawal}


case class Account(somme: BigDecimal, history: List[Operation]) {

  private val id = UUID.randomUUID.toString

  def bankId: String = id

  def deposit(value: PositifNumber, date: Date = Calendar.getInstance.getTime): Account =
    copy(somme + value, Deposit(value, somme, date) :: history)

  def withdrawal(value: PositifNumber, date: Date = Calendar.getInstance.getTime): Account =
    copy(somme - value, Withdrawal(value, somme, date) :: history)

}

object Account {

  def apply(): Account = Account(0, List.empty)

}





