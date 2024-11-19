package org.ghosttrio

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Executors

//fun main() {
//    fun task1() = println("일반함수 task1 : " + Thread.currentThread().name)
//    fun task2() = println("일반함수 task2 : " + Thread.currentThread().name)
//
//    suspend fun task3() = println("일시중단함수 task3 : " + Thread.currentThread().name)
//    val task4 = suspend { println("일시중단함수 task 4 : " + Thread.currentThread().name) }
//
//    val rb = runBlocking {
//        println("코루틴 처리 : " + coroutineContext)
//        launch {
//            delay(300)
//            task1()
//        }
//        launch {
//            delay(300)
//            task2()
//        }
//        launch {
//            delay(300)
//            task3()
//        }
//        launch {
//            delay(300)
//            task4()
//        }
//    }
//}

//fun coroutine() = runBlocking {
//    println("코루틴 처리")
//    repeat(100_000) {
//        launch {
//            delay(100L)
//            if (it % 10000 == 0) {
//                print(".")
//            }
//        }
//    }
//}
//
//fun thread() {
//    println("스레드 처리")
//    val executor = Executors.newFixedThreadPool(1024)
//
//    repeat(10000) {
//        executor.submit {
//            Thread.sleep(100L)
//            if (it % 1000 == 0) {
//                print("*")
//            }
//        }
//    }
//}
//
//fun main() {
//    coroutine()
//    println()
//    thread()
//}



//fun main() = runBlocking<Unit> {
//    fun strName() = Thread.currentThread().name
//    launch {
//        println("runBlocking : ${strName()}")
//    }
//
//    launch(Dispatchers.Unconfined) {
//        println("Unconfined : ${strName()}")
//    }
//
//    GlobalScope.launch {
//        println("GlobalScope : ${strName()}")
//    }
//
//    launch(Dispatchers.Default) {
//        println("Default : ${strName()}")
//    }
//
//    launch(newSingleThreadContext("스레드")) {
//        println("newSingleThreadContext : ${strName()}")
//    }
//}

//fun main() = runBlocking {
//    println("runBlocking : ${Thread.currentThread().name}")
//    println(coroutineContext)
//
//    GlobalScope.launch {
//        delay(100)
//        println("globalscope: ${Thread.currentThread().name}")
//        println(this.coroutineContext)
//    }
//
//    val c = CoroutineScope(Dispatchers.Default).launch {
//        delay(300)
//        println("CoroutineScope : ${Thread.currentThread().name}")
//        println(coroutineContext)
//    }
//
//    delay(1000)
//}

//fun main() = runBlocking<Unit> {
//    launch {
//        println("서브 코루틴 1 : ${Thread.currentThread().name}")
//        delay(300)
//        println("서브 코루틴 1 : 지연 후 처리 1")
//
//        launch {
//            delay(100)
//            println("서브 코루틴 2 : ${Thread.currentThread().name}")
//        }
//
//        delay(200)
//        println("서브 쿠로틴 1 : 지연후 처리 2")
//    }
//
//    println("메인 처리 시작")
//    delay(2000)
//    println("메인 처리 종료")
//}

//fun main() = runBlocking {
//    var ix = 0
//    var job = launch {
//        repeat(1000) {
//            _ -> println("job을 일시 중단 처리 : ${ix++}")
//            delay(500L)
//        }
//    }
//    delay(1300L)
//    println("main: 다른 코루틴 처리")
//    job.cancel()
//    job.join()
//}

//fun CoroutineScope.log(msg: String) {
//    val name = coroutineContext[CoroutineName]?.name
//    println("[$name] $msg")
//}
//
//fun main() {
//    GlobalScope.launch(CoroutineName("전역 스코프")) { 
//        log("launch 빌더 시작")
//        val job = launch { 
//            delay(500)
//            log("코루틴 처리 1")
//        }
//        
//        job.join()
//        log("launch 코루틴 빌더 정지")
//    }
//    Thread.sleep(1000)
//    println("메인 스레드 처리 2")
//}

fun CoroutineScope.log(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

//val syn = GlobalScope.async(CoroutineName("전역스코프")) {
//    log("현재 코루틴 1 : ${Thread.currentThread().name}")
//    async(Dispatchers.Default) {
//        delay(100)
//        log("현재 코루틴 2 : ${Thread.currentThread().name}")
//    }
//    delay(100)
//    log("코루틴 종료 : ${Thread.currentThread().name}")
//}
//
//suspend fun main() {
//    syn.await()
//}

//fun main() = runBlocking(CoroutineName("runBlocking")) {
//    val one = async {
//        doSomeOne()
//    }
//    val two = async {
//        doSomeTwo()
//    }
//
//    log("Result : ${one.await() + two.await()}")
//}
//suspend fun doSomeOne(): Int {
//    delay(1000L)
//    return 10
//}
//suspend fun doSomeTwo(): Int {
//    delay(1000L)
//    return 20
//}

//fun main() = runBlocking {
//    val deferred = async {
//        delay(1000)
//        "async result"
//    }
//}

//fun main() {
//    val handler = CoroutineExceptionHandler {_, exception -> println("예외처리 $exception") }
//    try {
//        runBlocking {
//            val job = launch(handler) {
//                throw Exception("첫 번째 코루틴 내에서 예외 발생")
//            }
//        }
//    } catch (e: Exception) {
//        println(e.message)
//    }
//}

//fun aaa() = runBlocking {
//    val chan = Channel<Int>()
//
//    launch {
//        for (x in 1..5) chan.send(x * x)
//    }
//
//    launch {
//        repeat(3) {
//            delay(10)
//            println("코루틴 1 : " + chan.receive())
//        }
//    }
//    launch {
//        repeat(2) {
//            delay(20)
//            println("코루틴 2 : " + chan.receive())
//        }
//    }
//    delay(200)
//    chan.close()
//}
//
//fun main() {
//    aaa()
//}


//fun CoroutineScope.produceSquares() = produce {
//    for (x in 1..5) {
//        send(x * x)
//    }
//}
//
//fun main() {
//    runBlocking {
//        val se = produceSquares()
//        se.consumeEach {
//            println(it)
//        }
//    }
//}

//fun fooFlow(): Flow<Int> = flow {
//    for (i in 1..3) {
//        delay(100)
//        emit(i)
//    }
//}
//
//suspend fun main () {
//    fooFlow().collect {
//        value -> println("$value")
//    }
//}

suspend fun main() {
    val actor1 = runBlocking {
        actor<String>(capacity = 10) {
            for (data in channel) {
                println(data + " Thread " + Thread.currentThread().name)
            }
        }
    }
    (1..5).forEach {
        actor1.send(it.toString())
    }
    actor1.close()
    delay(500L)

}