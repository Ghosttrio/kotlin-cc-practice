import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

//fun main() {
//    val cores = Runtime.getRuntime().availableProcessors()
//    println("코어 개수 : $cores")
//    println("메인 스레드 : ${Thread.currentThread()}")
//    task1()
//    task2()
//}
//
//fun task1() {
//    println("task1 스레드 : ${Thread.currentThread()}")
//}
//
//fun task2() {
//    println("task2 스레드 : ${Thread.currentThread()}")
//}


//fun exec(tr: Thread) {
//    println("${tr} : 보조 스레드 작동중")
//}
//class MyThread: Thread() {
//    override fun run() {
//        val tr = Thread.currentThread()
//        exec(tr)
//        println("${tr} : 보조 스레드 종료")
//    }
//}
//fun main () {
//    val mtr = Thread.currentThread()
//    println("${mtr} : 메인 스레드 작동중")
//
//    val myThread = MyThread()
//    myThread.start()
//
//    exec(myThread)
//
//    println("${mtr} : 대기중")
//    myThread.join() // 보조 스레드 종료 대기
//}

//class SimpleThread: Thread() {
//    override fun run() {
//        println("현재 스레드 이름 : ${this.getName()}")
//    }
//}
//
//fun main() {
//    val thread = SimpleThread()
//    thread.run()
//    println("스레드 활동 여부 : ${thread.isAlive}")
//    thread.join()
//    println("스레드 활동 여부 : ${thread.isAlive}")
//
//    val thread2 = SimpleThread()
//    thread2.start()
//    println("스레드 활동 여부 : ${thread2.isAlive}")
//    thread2.join()
//    println("스레드 활동 여부 : ${thread2.isAlive}")
//}


//class First: Runnable {
//    override fun run() {
//        println("a 5000 sleep")
//        Thread.sleep(5000)
//    }
//}
//
//class Second: Runnable {
//    override fun run() {
//        println("b 5000 sleep")
//        Thread.sleep(5000)
//    }
//}
//fun main() {
//    val obj1 = First()
//    val thread1 = Thread(obj1)
//    val obj2 = Second()
//    val thread2 = Thread(obj2)
//
//    thread1.start()
//    thread2.start()
//
//    thread1.join()
//    thread2.join()
//}


//fun createThread(): Thread {
//    return object : Thread() {
//        override fun run() {
//            println("5000 sleep")
//            Thread.sleep(5000)
//        }
//    }
//}
//
//val thread1 = createThread()
//val thread2 = createThread()


//val myThread = thread { println("${Thread.currentThread()}") }
//
//fun main() {
//    myThread.join()
//}

//fun makeThread(start: Boolean = true,
//               isDaemon: Boolean = false,
//               contextClassLoader: ClassLoader? = null,
//               name: String? = null,
//               priority: Int = -1,
//               block: () -> Unit) : Thread {
//    val thread = object : Thread() {
//        override fun run() {
//            block()
//        }
//    }
//    if (isDaemon) thread.isDaemon = true
//    if (priority > 0) thread.priority = priority
//    name?.let { thread.name = it }
//    contextClassLoader?.let { thread.contextClassLoader = it }
//    return thread
//}


//var x = 100
//
//class ThreadTest(var processCount : Int = 0) : Thread() {
//    init {
//        println("스레드 객체 생성")
//    }
//
//    override fun run() {
//        println("작업 스레드 : " + this.getName() + " START")
//        while (processCount > 0) {
//            Thread.sleep(1000)
//            processCount--
//            x += 77
//        }
//    }
//}
//
//fun startedThread(milTime: Long) {
//    val t1 = Thread.currentThread()
//    println("메인 스레드 : " + t1.getName())
//    val t2 = ThreadTest(1)
//    t2.start()
//    println("조인 호출")
//    t2.join(milTime)
//    println("변수 값 확인: $x")
//    println("조인 반환")
//}
//
//fun main() {
//    startedThread(3000)
//    println("변수 값 확인 : $x")
//}

//var count = 0
//val threads = List(10) {
//    thread {
//        Thread.sleep(1000)
//        print(".")
//        count += 1
//        print(count)
//    }
//}
//fun main() {
//    threads.forEach(Thread::join)
//}

//val executor = Executors.newFixedThreadPool(2)
//var count = 0
//
//fun main() {
//    repeat(3) {
//        executor.execute {
//            Thread.sleep(10)
//            println(Thread.currentThread().name)
//            count += 1
//            println(count)
//        }
//    }
//    println(executor.isTerminated)
//    executor.shutdown()
//    println(executor.isShutdown)
//}


//class Task(val name: String) : Runnable {
//    override fun run() {
//        val d = Date()
//        val ft = SimpleDateFormat("hh:mm:ss")
//        println("초기 시간 확인 task name - " + name + " = " + ft.format(d))
//        Thread.sleep(100)
//    }
//}
//
//val MAX_T = 5
//
//fun main() {
//    val r1 = Task("task1")
//    val r2 = Task("task2")
//    val r3 = Task("task3")
//    val r4 = Task("task4")
//    val r5 = Task("task5")
//
//    val pool = Executors.newFixedThreadPool(MAX_T)
//    pool.execute(r1)
//    pool.execute(r2)
//    pool.execute(r3)
//    pool.execute(r4)
//    pool.execute(r5)
//
//    pool.awaitTermination(3000L, TimeUnit.MILLISECONDS)
//}

//fun main() {
//    val task = object : Runnable {
//        override fun run() {
//            println("Thread: " + Thread.currentThread().name)
//        }
//    }
//
//    val service = Executors.newFixedThreadPool(5)
//    for (i in 1..10) {
//        service.submit(task)
//    }
//    service.shutdown()
//}

//val callable = {
//    Thread.sleep(10)
//    println("Thread: " + Thread.currentThread().name)
//}
//fun main() {
//    val service = Executors.newFixedThreadPool(5)
//
//    val future1 = service.submit(callable)
//    val future2 = service.submit(callable)
//    val future3 = service.submit(callable)
//
//    val value = future1.get() // 작업 끝날 때까지 기다려 값 받기
//    val cancel = future2.cancel(true) // 작업 취소 여부만 돌려받음
//}

fun main() {
    val service = Executors.newFixedThreadPool(2)
    val callable = {
        Thread.sleep(10)
        println("Thread: " + Thread.currentThread().name)
        1
    }
    val callableList = mutableListOf<Callable<Int>>()
    for (i in 1..3) {
        callableList.add(callable)
    }
    val futures = service.invokeAll(callableList)
    for (i in 0..2) {
        println(futures[i].get())
    }
}