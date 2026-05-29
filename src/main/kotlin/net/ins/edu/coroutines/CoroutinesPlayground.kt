package net.ins.edu.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.slf4j.MDCContext
import kotlinx.coroutines.slf4j.MDCContextMap
import net.ins.edu.coroutines.Employee.Companion.of
import org.slf4j.LoggerFactory
import java.math.BigDecimal

val logger = LoggerFactory.getLogger("CoroutinesPlayground")

fun main() = runBlocking {
    val resultOne = getCoupleOfEmployees()
    println(resultOne)

    val id = 0L
    val coroutineScope = CoroutineScope(Job() + Dispatchers.Default + MDCContext(id.toDepartmentIdMdcContext()))
    val findDepartmentJob = coroutineScope.launch {
        val resultTwo = Dao.findDepartment(0)
        logger.info("Found: $resultTwo")
    }
    findDepartmentJob.join()

    val findDepartmentDeferred = coroutineScope.async(Job() + Dispatchers.IO) {
        return@async Dao.findDepartment(2)
    }
    println(findDepartmentDeferred.await())
}

suspend fun getCoupleOfEmployees(): List<Employee> {
    val emplOne = Dao.findEmployee(1)
    val emplTwo = Dao.findEmployee(2)
    return listOf<Employee>(emplOne, emplTwo)
}

data class Employee(val id: Long, val email: String, val salary: BigDecimal) {
    companion object {
        fun of(id: Long): Employee = Employee(id, "$id@mail.org", BigDecimal.valueOf(1000 + (id * 10)))
    }
}

data class Department(val id: Long, val employees: List<Employee>)

object Dao {
    private val departments: List<Department> = listOf(
        Department(0, listOf(of(0), of(1), of(2))),
        Department(1, listOf(of(3), of(4), of(5), of(6))),
        Department(2, listOf(of(7), of(8))),
    )

    suspend fun findDepartment(id: Long): Department {
        delay(1000)
        return departments.firstOrNull { it.id == id } ?: throw EntityNotFoundException()
    }

    suspend fun findEmployee(id: Long): Employee {
        delay(2000)
        return departments.flatMap { it.employees }.firstOrNull { it.id == id } ?: throw EntityNotFoundException()
    }
}

class EntityNotFoundException() : RuntimeException()

fun Long.toEmployeeIdMdcContext(): MDCContextMap = mapOf("employee.id" to this.toString())
fun Long.toDepartmentIdMdcContext(): MDCContextMap = mapOf("department.id" to this.toString())