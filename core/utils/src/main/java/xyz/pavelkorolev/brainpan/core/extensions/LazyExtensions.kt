package xyz.pavelkorolev.brainpan.core.extensions

/**
 * Non thread-safe lazy delegate.
 */
fun <T> lazyFast(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)
