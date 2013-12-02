eq(Y1, Y2, Y3) :- Y1 = Y2, Y2 = Y3. /*all arguments equals */
diff(Y1, Y2, N) :- N is Y2 - Y1. /* Y2 is N greater than Y1*/
moveRight(Xo, Yo, Mx, My, Rx, Ry) :- Mx is Xo, My is Yo, Rx is Mx + 1, Ry is My + 1.
moveLeft(Xo, Yo, Mx, My, Rx, Ry) :- Mx is Xo, My is Yo, Rx is Mx - 1, Ry is My + 1.

buba(X, Y) :- Y = 2.

move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- start(X1, Y1, Y2, Y3, X4, Y4, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- a(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- a1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- a2(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- a3(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- b(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- b1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- c(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- c1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- d(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- d1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- e(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- e1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- e2(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- e3(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry).
move(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- e4(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry).


start(X1, Y1, Y2, Y3, X4, Y4, Mx, My, Rx, Ry) :- start_pos1(Y1, Y2, Y3, X4, Y4), moveLeft(X4, Y4, Mx, My, Rx, Ry).
start(X1, Y1, Y2, Y3, X4, Y4, Mx, My, Rx, Ry) :- start_pos2(X1, Y1, Y2, Y3, Y4), moveRight(X1, Y1, Mx, My, Rx, Ry).
start_pos(Y1, Y2, Y3, Y4) :- eq(Y1, Y2, Y3), Y3 = Y4.
start_pos1(Y1, Y2, Y3, X4, Y4) :-  start_pos(Y1, Y2, Y3, Y4), X4 = 7.
start_pos2(X1, Y1, Y2, Y3, Y4) :-  start_pos(Y1, Y2, Y3, Y4), X1 = 0.

a(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- a_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), (a_dan1(X2, Y2, Wx, Wy, X1, Y1, Mx, My, Rx, Ry); moveLeft(X3, Y3, Mx, My, Rx, Ry)).
a(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- a_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), (a_dan2(X2, Y2, Wx, Wy, X4, Y4, Mx, My, Rx, Ry); moveRight(X2, Y2, Mx, My, Rx, Ry)).
a_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- eq(Y1, Y2, Y3), diff(Y3, Y4, 1), diff(X1, X2, 2), diff(X2, X3, 2), diff(X3, X4, 1).
a_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- eq(Y2, Y3, Y4), diff(Y2, Y1, 1), diff(X1, X2, 1), diff(X2, X3, 2), diff(X3, X4, 2).
a_dan(X2, Y2, Wx, Wy) :- diff(Y2, Wy, 1), diff(X2, Wx, 1).
a_dan1(X2, Y2, Wx, Wy, Xt, Yt, Mx, My, Rx, Ry) :- a_dan(X2, Y2, Wx, Wy), moveRight(Xt, Yt, Mx, My, Rx, Ry).
a_dan2(X2, Y2, Wx, Wy, Xt, Yt, Mx, My, Rx, Ry) :- a_dan(X2, Y2, Wx, Wy), moveLeft(Xt, Yt, Mx, My, Rx, Ry).

a1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- a1_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveLeft(X3, Y3, Mx, My, Rx, Ry).
a1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- a1_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveRight(X3, Y3, Mx, My, Rx, Ry).
a1pos(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- Y1 = Y4, Y2 = Y3, diff(X1, X2, 1), diff(X2, X3, 2), diff(X3, X4, 1).
a1_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- a1pos(X1, Y1, X2, Y2, X3, Y3, X4, Y4), X1 < 7 - X4.
a1_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- a1pos(X1, Y1, X2, Y2, X3, Y3, X4, Y4), X1 > 7 - X4.

a2(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- a2_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveLeft(X1, Y1, Mx, My, Rx, Ry).
a2(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- a2_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveRight(X4, Y4, Mx, My, Rx, Ry).
a2_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- eq(Y1, Y3, Y4), diff(Y2, Y1, 1), diff(X1, X2, 1), diff(X2, X3, 1), diff(X3, X4, 2).
a2_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- eq(Y1, Y2, Y4), diff(Y3, Y1, 1), diff(X1, X2, 2), diff(X2, X3, 1), diff(X3, X4, 1).

a3(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- a3_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveLeft(X2, Y2, Mx, My, Rx, Ry).
a3(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- a3_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveRight(X3, Y3, Mx, My, Rx, Ry).
a3pos(X1, X2, X3, X4) :- diff(X1, X2, 2), diff(X2, X3, 1), diff(X3, X4, 2).
a3_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- a3pos(X1, X2, X3, X4), Y3 = Y4, diff(Y2, Y3, 1), diff(Y2, Y1, 2).
a3_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- a3pos(X1, X2, X3, X4), Y1 = Y2, diff(Y3, Y4, 2), diff(Y3, Y2, 1).


b(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- b_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), (b_dan1(X2, Y2, X4, Y4, Wx, Wy, Mx, My, Rx, Ry); moveLeft(X2, Y2, Mx, My, Rx, Ry)).
b(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- b_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), (b_dan2(X4, Y4, X1, Y1, Wx, Wy, Mx, My, Rx, Ry); moveRight(X3, Y3, Mx, My, Rx, Ry)).
bpos(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- Y1 = Y2, Y3 = Y4, diff(X1, X2, 2), diff(X2, X3, 1), diff(X3, X4, 2).
b_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- bpos(X1, Y1, X2, Y2, X3, Y3, X4, Y4), diff(Y2, Y3, 1).
b_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- bpos(X1, Y1, X2, Y2, X3, Y3, X4, Y4), diff(Y3, Y2, 1).
bdan(Xo, Yo, Wx, Wy) :- diff(Yo, Wy, 1), diff(Wx, Xo, 1).
b_dan1(X2, Y2, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- bdan(X2, Y2, Wx, Wy), moveLeft(X4, Y4, Mx, My, Rx, Ry).
b_dan2(X4, Y4, X1, Y1, Wx, Wy, Mx, My, Rx, Ry) :- bdan(X4, Y4, Wx, Wy), moveRight(X1, Y1, Mx, My, Rx, Ry).

b1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- b1_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveLeft(X2, Y2, Mx, My, Rx, Ry).
b1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- b1_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveRight(X3, Y3, Mx, My, Rx, Ry).
b1_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- Y1 = Y2, diff(Y2, Y3, 1), diff(Y3, Y4, 1), diff(X1, X2, 2), diff(X2, X3, 1), diff(X3, X4, 1).
b1_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- Y3 = Y4, diff(Y3, Y2, 1), diff(Y2, Y1, 1), diff(X1, X2, 1), diff(X2, X3, 1), diff(X3, X4, 2).


c(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- c_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), (c_dan1(X2, Y2, X4, Y4, Wx, Wy, Mx, My, Rx, Ry); moveLeft(X2, Y2, Mx, My, Rx, Ry)).
c(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- c_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), (c_dan2(X3, Y3, X1, Y1, Wx, Wy, Mx, My, Rx, Ry); moveRight(X3, Y3, Mx, My, Rx, Ry)).
c_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- eq(Y2, Y3, Y4), diff(Y1, Y2, 1), diff(X1, X2, 1), diff(X2, X3, 2), diff(X3, X4, 2).
c_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- eq(Y1, Y2, Y3), diff(Y4, Y3, 1), diff(X1, X2, 2), diff(X2, X3, 2), diff(X3, X4, 1).
cdan(Xo, Yo, Wx, Wy) :- diff(Yo, Wy, 1), diff(Xo, Wx, 1), diff(Wx, Xo, 1).
c_dan1(X2, Y2, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- cdan(X2, Y2, Wx, Wy), moveLeft(X4, Y4, Mx, My, Rx, Ry).
c_dan2(X3, Y3, X1, Y1, Wx, Wy, Mx, My, Rx, Ry) :- cdan(X3, Y3, Wx, Wy), moveRight(X1, Y1, Mx, My, Rx, Ry).

c1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- c1_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveRight(X1, Y1, Mx, My, Rx, Ry).
c1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- c1_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveLeft(X3, Y3, Mx, My, Rx, Ry).
c1_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- X1 = X2, Y3 = Y4, diff(Y1, Y2, 2), diff(Y3, Y2, 1), diff(X3, X4, 2), diff(X1, X3, 3).
c1_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- X3 = X4, Y1 = Y2, diff(Y3, Y4, 2), diff(Y2, Y4, 1), diff(X1, X2, 2), diff(X2, X3, 3).


d(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- d_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), (d_dan1(X2, Y2, X4, Y4, Wx, Wy, Mx, My, Rx, Ry); moveLeft(X2, Y2, Mx, My, Rx, Ry)).
d(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- d_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), (d_dan2(X3, Y3, X1, Y1, Wx, Wy, Mx, My, Rx, Ry); moveRight(X3, Y3, Mx, My, Rx, Ry)).
dpos(X1, X2, Y2, X3, Y3, X4) :- Y2 = Y3, diff(X1, X2, 1), diff(X2, X3, 2), diff(X3, X4, 1), X4 = 5.
d_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- dpos(X1, X2, Y2, X3, Y3, X4), diff(Y1, Y2, 1), diff(Y3, Y4, 1).
d_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- dpos(X1, X2, Y2, X3, Y3, X4), diff(Y2, Y1, 1), diff(Y4, Y3, 1).
d_dan1(X4, Y4, X2, Y2, Wx, Wy, Mx, My, Rx, Ry) :- diff(Y4, Wy, 1), diff(Wx, X4, 1), moveRight(X2, Y2, Mx, My, Rx, Ry).
d_dan2(X1, Y1, X3, Y3, Wx, Wy, Mx, My, Rx, Ry) :- diff(Y1, Wy, 1), diff(X1, Wx, 1), moveLeft(X3, Y3, Mx, My, Rx, Ry).

d1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- d1_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveRight(X1, Y1, Mx, My, Rx, Ry).
d1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- d1_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveLeft(X3, Y3, Mx, My, Rx, Ry).
d1_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- diff(Y1, Y2, 2), diff(Y3, Y2, 1), diff(Y3, Y4, 1), X1 = X2, diff(X3, X4, 1), diff(X1, X3, 3).
d1_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- diff(Y3, Y4, 2), diff(Y3, Y2, 1), diff(Y2, Y1, 1), X3 = X4, diff(X2, X3, 3), diff(X1, X2, 1).


e(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- e_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), (e_dan1(X2, Y2, X4, Y4, Wx, Wy, Mx, My, Rx, Ry); moveRight(X1, Y1, Mx, My, Rx, Ry)).
e(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- e_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), (e_dan2(X3, Y3, X1, Y1, Wx, Wy, Mx, My, Rx, Ry); moveLeft(X4, Y4, Mx, My, Rx, Ry)).
e_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- diff(Y1, Y2, 2), diff(Y3, Y2, 1), Y2 = Y4, diff(X1, X2, 2), diff(X2, X3, 1), diff(X3, X4, 1).
e_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- Y1 = Y3, diff(Y2, Y1, 1), diff(Y4, Y3, 2), diff(X1, X2, 1), diff(X2, X3, 1), diff(X3, X4, 2).
edan(Xo, Yo, Wx, Wy) :- diff(Yo, Wy, 2), Xo = Wx.
e_dan1(X4, Y4, Wx, Wy, Mx, My, Rx, Ry) :- edan(X4, Y4, Wx, Wy), moveRight(X4, Y4, Mx, My, Rx, Ry).
e_dan2(X1, Y1, Wx, Wy, Mx, My, Rx, Ry) :- edan(X1, Y1, Wx, Wy), moveLeft(X1, Y1, Mx, My, Rx, Ry).

e1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- e1_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveRight(X3, Y3, Mx, My, Rx, Ry).
e1(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- e1_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveLeft(X2, Y2, Mx, My, Rx, Ry).
e1pos(X1, X2, X3, X4) :- diff(X1, X2, 2), diff(X2, X3, 1), diff(X3, X4, 2).
e1_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- e1pos(X1, X2, X3, X4), diff(Y1, Y2, 2), diff(Y3, Y2, 1), diff(Y3, Y4, 2).
e1_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- e1pos(X1, X2, X3, X4), diff(Y2, Y1, 2), diff(Y2, Y3, 1), diff(Y4, Y3, 2).

e2(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- e2_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveRight(X1, Y1, Mx, My, Rx, Ry).
e2(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- e2_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveLeft(X4, Y4, Mx, My, Rx, Ry).
e2_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- diff(Y1, Y2, 2), Y2 = Y3, diff(Y3, Y4, 1), diff(X1, X2, 2), diff(X2, X3, 2), diff(X3, X4, 1).
e2_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- diff(Y2, Y1, 1), Y2 = Y3, diff(Y4, Y3, 2), diff(X1, X2, 1), diff(X2, X3, 2), diff(X3, X4, 2).

e3(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- e3_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveLeft(X1, Y1, Mx, My, Rx, Ry).
e3(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- e3_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveRight(X4, Y4, Mx, My, Rx, Ry).
e3pos(X1, X2, Y2, X3, Y3, X4) :- Y2 = Y3, diff(X1, X2, 1), diff(X2, X3, 2), diff(X3, X4, 1), X4 = 6.
e3_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- e3pos(X1, X2, Y2, X3, Y3, X4), diff(Y1, Y2, 1), diff(Y3, Y4, 1).
e3_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- e3pos(X1, X2, Y2, X3, Y3, X4), diff(Y2, Y1, 1), diff(Y4, Y3, 1).

e4(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- e4_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveLeft(X1, Y1, Mx, My, Rx, Ry).
e4(X1, Y1, X2, Y2, X3, Y3, X4, Y4, Mx, My, Rx, Ry) :- e4_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4), moveRight(X4, Y4, Mx, My, Rx, Ry).
e4pos(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- Y2 = Y4, Y1 = Y3, diff(X1, X2, 1), diff(X2, X3, 1), diff(X3, X4, 1).
e4_pos1(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- e4pos(X1, Y1, X2, Y2, X3, Y3, X4, Y4), diff(Y1, Y2, 1).
e4_pos2(X1, Y1, X2, Y2, X3, Y3, X4, Y4) :- e4pos(X1, Y1, X2, Y2, X3, Y3, X4, Y4), diff(Y2, Y1, 1).



