package bank.model

import java.util.{Calendar, Date, UUID}

import bank.model.Operation.{Deposit, Withdrawal}


case class Compte(somme: Double, history: List[Operation]) {

  private val id = UUID.randomUUID.toString

  def bankId: String = id

  def depot(value: PositifNumber, date: Date = Calendar.getInstance.getTime): Compte = copy(somme + value, Deposit(value, somme, date) :: history)

  def retry(value: PositifNumber, date: Date = Calendar.getInstance.getTime): Compte = copy(somme - value, Withdrawal(value, somme, date) :: history)

}

object Compte {

  def apply(): Compte = Compte(0, List.empty)

}





