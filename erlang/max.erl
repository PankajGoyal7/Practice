% @Author: pankajgoyal7
% @Date:   2018-06-18 01:56:21
% @Last Modified by:   pankajgoyal7
% @Last Modified time: 2018-06-18 02:02:44
-module(max).
-export([list_max/1]).

list_max([Head|Rest]) ->
	list_max(Rest,Head).

list_max([],Res) ->
	Res;
list_max([Head|Rest],Result_so_far) when Head > Result_so_far ->
	list_max(Rest,Head);
list_max([Head|Rest],Result_so_far) ->
	list_max(Rest,Result_so_far).
