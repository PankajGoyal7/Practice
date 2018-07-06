% @Author: pankajgoyal7
% @Date:   2018-06-18 11:37:14
% @Last Modified by:   pankajgoyal7
% @Last Modified time: 2018-06-18 11:39:20
-module(concurrent).
-export([start/0,say_something/2]).

say_something(What,0) ->
	done;
say_something(What,Times) ->
	io:format(" ~p~n",[What]),
	say_something(What,Times - 1 ).

start() ->
	spawn(concurrent,say_something,[hello,3]),
	spawn(concurrent,say_something,[bye,3]).