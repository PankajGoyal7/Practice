% @Author: pankajgoyal7
% @Date:   2018-06-18 00:00:04
% @Last Modified by:   pankajgoyal7
% @Last Modified time: 2018-06-18 00:08:04
-module(tut).
-export([fac/1, mult/2,convert/2]).

fac(1) ->
    1;
fac(N) ->
    N * fac(N - 1).

mult(X, Y) ->
    X * Y.

convert(M,inch) ->
	M / 2.54;

convert(M,centimeter) ->
	M * 2.54.