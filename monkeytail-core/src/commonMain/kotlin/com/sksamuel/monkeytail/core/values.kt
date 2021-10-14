package com.sksamuel.monkeytail.core

import com.sksamuel.monkeytail.core.validation.invalid
import com.sksamuel.monkeytail.core.validation.valid

/**
 * Returns a [Parser] that rejects the output of this parser if the output is not one
 * of the given acceptable values. In the case of rejection, the error message
 * is generated by the given function [ifFalse].
 *
 * @param values the allowed list of values
 * @param ifFalse the error generating function
 *
 * @return a parser which rejects input if not in the allowed list.
 */
fun <I, A, E> Parser<I, A, E>.oneOf(values: List<A>, ifFalse: (A) -> E): Parser<I, A, E> {
   return flatMap { if (values.contains(it)) it.valid() else ifFalse(it).invalid() }
}

