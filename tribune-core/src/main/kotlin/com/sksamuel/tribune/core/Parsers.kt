package com.sksamuel.tribune.core

import com.sksamuel.tribune.core.strings.notNullOrBlank

/**
 * [Parsers] contains some useful starter parsers.
 */
object Parsers {

   /**
    * An identity [Parser] for nullable strings.
    */
   val nullableString: Parser<String?, String?, Nothing> = Parser()

   /**
    * A [Parser] for nullable types, which returns the input if not null, or an error if null.
    * The error is derived from the given [errorFn] function.
    */
   fun <I, E> notNull(errorFn: () -> E): Parser<I?, I, E> = Parser<I?>().notNull { errorFn() }

   /**
    * A [Parser] for nullable Strings, which returns the input if not blank, or an error if null or blank.
    * The error is derived from the given [errorFn] function.
    */
   fun <E> nonBlankString(errorFn: () -> E): Parser<String?, String, E> =
      Parser<String?>().notNullOrBlank { errorFn() }
}