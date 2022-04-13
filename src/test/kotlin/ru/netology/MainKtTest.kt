package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {
    @Test
    fun convertPriceToString_ShouldConvertIntToString() {
        val price = 96_55

        val result = convertPriceToString(sum = price)

        assertEquals("96 руб. 55 коп.", result)

    }

    @Test
    fun visaMirComissionCalculator_ShouldCalculateMinComission() {

        val transfer = 4000_00

        val result = visaMirComissionCalculator(transfer)

        assertEquals(35_00, result)

    }

    @Test
    fun visaMirComissionCalculator_ShouldCalculate075Comission() {

        val transfer = 10000_00

        val result = visaMirComissionCalculator(transfer)

        assertEquals(75_00, result)

    }

    @Test
    fun mastrercardMaestroComissionCalculator_ShouldCalculateComission() {
        val transfer = 10000_00

        //0.6% + 20
        //10000_00 * 0.006 + 20_00 = 80_00

        val result = mastrercardMaestroComissionCalculator(transfer)

        assertEquals(80_00, result)
    }

    @Test
    fun calculateComission_Visa_ShouldCalculateZeroForCashIn() {
        val cardTypeVisa = "Visa"
        val transferIn = true
        val dayTransferAmount = 10_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeVisa, monthTransferAmount, dayTransferAmount)
        assertEquals(0, result)
    }

    @Test
    fun calculateComission_Visa_ShouldCalculate075ComissionCashOut() {
        val cardTypeVisa = "Visa"
        val transferIn = false
        val dayTransferAmount = 10_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeVisa, monthTransferAmount, dayTransferAmount)
        assertEquals(7500, result)
    }

    @Test
    fun calculateComission_Visa_ShouldCalculateMinComissionCashOut() {
        val cardTypeVisa = "Visa"
        val transferIn = false
        val dayTransferAmount = 4_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeVisa, monthTransferAmount, dayTransferAmount)
        assertEquals(3500, result)
    }

    @Test
    fun calculateComission_Mir_ShouldCalculateZeroForCashIn() {
        val cardTypeMir = "Мир"
        val transferIn = true
        val dayTransferAmount = 4_000_00
        val monthTransferAmount = 100_000_00

        val result = calculateComission(transferIn, cardTypeMir, monthTransferAmount, dayTransferAmount)
        assertEquals(0, result)

    }

    @Test
    fun calculateComission_Mir_ShouldCalculate075ComissionCashOut() {
        val cardTypeMir = "Мир"
        val transferIn = false
        val dayTransferAmount = 10_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeMir, monthTransferAmount, dayTransferAmount)
        assertEquals(7500, result)

    }

    @Test
    fun calculateComission_Mir_ShouldCalculateMinComissionCashOut() {
        val cardTypeMir = "Мир"
        val transferIn = false
        val dayTransferAmount = 4_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeMir, monthTransferAmount, dayTransferAmount)
        assertEquals(3500, result)

    }

    @Test
    fun calculateComission_MasterCard_ShouldCalculateZeroForCashIn() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = true
        val dayTransferAmount = 4_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeMasterCard, monthTransferAmount, dayTransferAmount)
        assertEquals(0, result)
    }

    @Test
    fun calculateComission_MasterCard_ShouldCalculateComissionUnder75000LimitCashOut() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = false
        val dayTransferAmount = 10_000_00
        val monthTransferAmount = 50_000_00
        val result = calculateComission(transferIn, cardTypeMasterCard, monthTransferAmount, dayTransferAmount)
        assertEquals(0, result)

    }

    @Test
    fun calculateComission_MasterCard_ShouldCalculateComissionOver75000LimitCashOut() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = false
        val dayTransferAmount = 10_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeMasterCard, monthTransferAmount, dayTransferAmount)
        assertEquals(8000, result)
    }

    @Test
    fun calculateComission_Maestro_ShouldCalculateZeroForCashIn() {
        val cardTypeMaestro = "Maestro"
        val transferIn = true
        val dayTransferAmount = 4_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeMaestro, monthTransferAmount, dayTransferAmount)
        assertEquals(0, result)
    }

    @Test
    fun calculateComission_Maestro_ShouldCalculateComissionUnder75000LimitCashOut() {
        val cardTypeMaestro = "Maestro"
        val transferIn = false
        val dayTransferAmount = 10_000_00
        val monthTransferAmount = 50_000_00
        val result = calculateComission(transferIn, cardTypeMaestro, monthTransferAmount, dayTransferAmount)
        assertEquals(0, result)

    }

    @Test
    fun calculateComission_Maestro_ShouldCalculateComissionOver75000LimitCashOut() {
        val cardTypeMaestro = "Maestro"
        val transferIn = false
        val dayTransferAmount = 10_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeMaestro, monthTransferAmount, dayTransferAmount)
        assertEquals(8000, result)
    }

    @Test
    fun calculateComission_VKPay_ShouldCalculateZeroForCashIn() {
        val cardTypeVKPay = "VKPay"
        val transferIn = true
        val dayTransferAmount = 4_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeVKPay, monthTransferAmount, dayTransferAmount)
        assertEquals(0, result)
    }

    @Test
    fun calculateComission_VKPay_ShouldCalculateZeroForCashOut() {
        val cardTypeVKPay = "VKPay"
        val transferIn = false
        val dayTransferAmount = 4_000_00
        val monthTransferAmount = 100_000_00
        val result = calculateComission(transferIn, cardTypeVKPay, monthTransferAmount, dayTransferAmount)
        assertEquals(0, result)
    }

    @Test
    fun calculateComission_Default() {
        val transferAmount = 4_000_00
        val result = calculateComission(transfer = transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun cashTransferPossible_CashInVKPayUnderDayLimit() {
        val cardTypeVKPay = "VKPay"
        val transferIn = true
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeVKPay, dayTransferAmount, periodDay)
        assertEquals(true, isPossibleDay)

    }

    @Test
    fun cashTransferPossible_CashInVKPayOverDayLimit() {
        val cardTypeVKPay = "VKPay"
        val transferIn = true
        val dayTransferAmount = 20_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeVKPay, dayTransferAmount, periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashInVKPayUnderMonthLimit() {
        val cardTypeVKPay = "VKPay"
        val transferIn = true
        val monthTransferAmount = 20_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeVKPay, monthTransferAmount, periodMonth)
        assertEquals(true, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashInVKPayOverMonthLimit() {
        val cardTypeVKPay = "VKPay"
        val transferIn = true
        val monthTransferAmount = 120_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeVKPay, monthTransferAmount, periodMonth)
        assertEquals(false, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashOutVKPayUnderDayLimit() {
        val cardTypeVKPay = "VKPay"
        val transferIn = false
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeVKPay, dayTransferAmount, periodDay)
        assertEquals(true, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashOutVKPayOverDayLimit() {
        val cardTypeVKPay = "VKPay"
        val transferIn = false
        val dayTransferAmount = 20_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeVKPay, dayTransferAmount, periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashOutVKPayUnderMonthLimit() {
        val cardTypeVKPay = "VKPay"
        val transferIn = false
        val monthTransferAmount = 20_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeVKPay, monthTransferAmount, periodMonth)
        assertEquals(true, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashOutVKPayOverMonthLimit() {
        val cardTypeVKPay = "VKPay"
        val transferIn = false
        val monthTransferAmount = 120_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeVKPay, monthTransferAmount, periodMonth)
        assertEquals(false, isPossibleMonth)
    }

    /*** Visa
     *
     */

    @Test
    fun cashTransferPossible_CashInVisaUnderDayLimit() {
        val cardTypeVisa = "Visa"
        val transferIn = true
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeVisa, dayTransferAmount, periodDay)
        assertEquals(true, isPossibleDay)

    }

    @Test
    fun cashTransferPossible_CashInVisaOverDayLimit() {
        val cardTypeVisa = "Visa"
        val transferIn = true
        val dayTransferAmount = 200_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeVisa, dayTransferAmount, periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashInVisaUnderMonthLimit() {
        val cardTypeVisa = "Visa"
        val transferIn = true
        val monthTransferAmount = 20_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeVisa, monthTransferAmount, periodMonth)
        assertEquals(true, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashInVisaOverMonthLimit() {
        val cardTypeVisa = "Visa"
        val transferIn = true
        val monthTransferAmount = 700_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeVisa, monthTransferAmount, periodMonth)
        assertEquals(false, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashOutVisaUnderDayLimit() {
        val cardTypeVisa = "Visa"
        val transferIn = false
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeVisa, dayTransferAmount, periodDay)
        assertEquals(true, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashOutVisaOverDayLimit() {
        val cardTypeVisa = "Visa"
        val transferIn = false
        val dayTransferAmount = 200_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeVisa, dayTransferAmount, periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashOutVisaUnderMonthLimit() {
        val cardTypeVisa = "Visa"
        val transferIn = false
        val monthTransferAmount = 20_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeVisa, monthTransferAmount, periodMonth)
        assertEquals(true, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashOutVisaOverMonthLimit() {
        val cardTypeVisa = "Visa"
        val transferIn = false
        val monthTransferAmount = 700_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeVisa, monthTransferAmount, periodMonth)
        assertEquals(false, isPossibleMonth)
    }

    /*** Mir
     *
     */


    @Test
    fun cashTransferPossible_CashInMirUnderDayLimit() {
        val cardTypeMir = "Мир"
        val transferIn = true
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMir, dayTransferAmount, periodDay)
        assertEquals(true, isPossibleDay)

    }

    @Test
    fun cashTransferPossible_CashInMirOverDayLimit() {
        val cardTypeMir = "Мир"
        val transferIn = true
        val dayTransferAmount = 200_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMir, dayTransferAmount, periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashInMirUnderMonthLimit() {
        val cardTypeMir = "Мир"
        val transferIn = true
        val monthTransferAmount = 20_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMir, monthTransferAmount, periodMonth)
        assertEquals(true, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashInMirOverMonthLimit() {
        val cardTypeMir = "Мир"
        val transferIn = true
        val monthTransferAmount = 700_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMir, monthTransferAmount, periodMonth)
        assertEquals(false, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashOutMirUnderDayLimit() {
        val cardTypeMir = "Мир"
        val transferIn = false
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMir, dayTransferAmount, periodDay)
        assertEquals(true, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashOutMirOverDayLimit() {
        val cardTypeMir = "Мир"
        val transferIn = false
        val dayTransferAmount = 200_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMir, dayTransferAmount, periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashOutMirUnderMonthLimit() {
        val cardTypeMir = "Мир"
        val transferIn = false
        val monthTransferAmount = 20_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMir, monthTransferAmount, periodMonth)
        assertEquals(true, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashOutMirOverMonthLimit() {
        val cardTypeMir = "Мир"
        val transferIn = false
        val monthTransferAmount = 700_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMir, monthTransferAmount, periodMonth)
        assertEquals(false, isPossibleMonth)
    }

    /*** MasterCard
     *
     */


    @Test
    fun cashTransferPossible_CashInMasterCardUnderDayLimit() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = true
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMasterCard, dayTransferAmount, periodDay)
        assertEquals(true, isPossibleDay)

    }

    @Test
    fun cashTransferPossible_CashInMasterCardOverDayLimit() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = true
        val dayTransferAmount = 200_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMasterCard, dayTransferAmount, periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashInMasterCardUnderMonthLimit() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = true
        val monthTransferAmount = 20_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMasterCard, monthTransferAmount, periodMonth)
        assertEquals(true, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashInMasterCardOverMonthLimit() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = true
        val monthTransferAmount = 700_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMasterCard, monthTransferAmount, periodMonth)
        assertEquals(false, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashOutMasterCardUnderDayLimit() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = false
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMasterCard, dayTransferAmount, periodDay)
        assertEquals(true, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashOutMasterCardOverDayLimit() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = false
        val dayTransferAmount = 200_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMasterCard, dayTransferAmount, periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashOutMasterCardUnderMonthLimit() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = false
        val monthTransferAmount = 20_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMasterCard, monthTransferAmount, periodMonth)
        assertEquals(true, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashOutMasterCardOverMonthLimit() {
        val cardTypeMasterCard = "MasterCard"
        val transferIn = false
        val monthTransferAmount = 700_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMasterCard, monthTransferAmount, periodMonth)
        assertEquals(false, isPossibleMonth)
    }

    /*** Maestro
     *
     */


    @Test
    fun cashTransferPossible_CashInMaestroUnderDayLimit() {
        val cardTypeMaestro = "Maestro"
        val transferIn = true
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMaestro, dayTransferAmount, periodDay)
        assertEquals(true, isPossibleDay)

    }

    @Test
    fun cashTransferPossible_CashInMaestroOverDayLimit() {
        val cardTypeMaestro = "Maestro"
        val transferIn = true
        val dayTransferAmount = 200_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMaestro, dayTransferAmount, periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashInMaestroUnderMonthLimit() {
        val cardTypeMaestro = "Maestro"
        val transferIn = true
        val monthTransferAmount = 20_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMaestro, monthTransferAmount, periodMonth)
        assertEquals(true, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashInMaestroOverMonthLimit() {
        val cardTypeMaestro = "Maestro"
        val transferIn = true
        val monthTransferAmount = 700_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMaestro, monthTransferAmount, periodMonth)
        assertEquals(false, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashOutMaestroUnderDayLimit() {
        val cardTypeMaestro = "Maestro"
        val transferIn = false
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMaestro, dayTransferAmount, periodDay)
        assertEquals(true, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashOutMaestroOverDayLimit() {
        val cardTypeMaestro = "Maestro"
        val transferIn = false
        val dayTransferAmount = 200_000_00
        val isPossibleDay = cashTransferPossible(transferIn, cardTypeMaestro, dayTransferAmount, periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_CashOutMaestroUnderMonthLimit() {
        val cardTypeMaestro = "Maestro"
        val transferIn = false
        val monthTransferAmount = 20_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMaestro, monthTransferAmount, periodMonth)
        assertEquals(true, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_CashOutMaestroOverMonthLimit() {
        val cardTypeMaestro = "Maestro"
        val transferIn = false
        val monthTransferAmount = 700_000_00
        val isPossibleMonth = cashTransferPossible(transferIn, cardTypeMaestro, monthTransferAmount, periodMonth)
        assertEquals(false, isPossibleMonth)
    }

    @Test
    fun cashTransferPossible_DefaultSmallSumDay() {
        val dayTransferAmount = 4_000_00
        val isPossibleDay = cashTransferPossible(transferSum = dayTransferAmount, limitType = periodDay)
        assertEquals(true, isPossibleDay)

    }

    @Test
    fun cashTransferPossible_DefaultBigSumDay() {
        val dayTransferAmount = 20_000_00
        val isPossibleDay = cashTransferPossible(transferSum = dayTransferAmount, limitType = periodDay)
        assertEquals(false, isPossibleDay)
    }

    @Test
    fun cashTransferPossible_DefaultSmallSumMonth() {
        val dayTransferAmount = 4_000_00
        val isPossibleMonth = cashTransferPossible(transferSum = dayTransferAmount, limitType = periodMonth)
        assertEquals(true, isPossibleMonth)

    }

    @Test
    fun cashTransferPossible_DefaultBigSumMonth() {
        val dayTransferAmount = 200_000_00
        val isPossibleMonth = cashTransferPossible(transferSum = dayTransferAmount, limitType = periodMonth)
        assertEquals(false, isPossibleMonth)
    }

}