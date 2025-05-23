# [Gold III] 조삼모사 - 1621 

[문제 링크](https://www.acmicpc.net/problem/1621) 

### 성능 요약

메모리: 140508 KB, 시간: 712 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 5월 11일 14:31:27

### 문제 설명

<p><img alt="" height="424" src="https://www.acmicpc.net/upload/201004/cscc.PNG" width="275"></p>

<p>조삼모사에 대한 자세한 설명은 위의 만화로 대신한다.</p>

<p>동물원에서 막 탈출한 원숭이 한 마리가 세상구경을 하고 있다. 그는 매일 바나나무료배급소에서 바나나를 배급받아 먹는다. 그러다 하루는 배급을 기다리는 N개의 바나나가 일렬로 놓여있는 것을 발견하게 되었다.</p>

<p>원숭이는 이 N개의 바나나를 모두 훔쳐서 자신의 은신처에 숨길 궁리를 하고 있다. 원숭이가 바나나를 훔칠 수 있는 방법은 두 가지가 있다. 첫 번째로는 바나나 한 개만 가져가는 경우가 있다. 이때 걸리는 시간은 바나나의 무게만큼 걸린다. 두 번째로는 연속하게 놓여있는 바나나 K개를 한꺼번에 들고 가는 경우가 있다. 이때 걸리는 시간은 일정한 상수 C만큼 걸린다. 은신처에서 배급소로 돌아가는 시간은 0초이다. 원숭이는 바나나를 들고 있지 않으면 순간이동을 할 수 있기 때문이다.</p>

<p>원숭이는 N개의 바나나를 모두 자신의 은신처로 옮겨야 한다. N개의 바나나들의 무게가 주어졌을 때, 바나나를 모두 옮길 수 있는 최소의 시간을 구하는 프로그램을 작성하시오. 원숭이는 한꺼번에 K개 들고 가는 것을 좋아하지 않는다. 즉, 답이 여러 개 존재하면, K개 들고 가는 횟수가 가장 적은 것을 구해야 한다는 뜻이다.</p>

### 입력 

 <p>첫째 줄에 바나나의 개수 N이 주어진다. N은 1이상 1,000,000이하인 자연수이다. 둘째 줄에 K, C가 주어진다. K, C는 1이상 10,000이하의 자연수이다. 그 다음 줄에 바나나의 무게를 나타내는 N개의 자연수가 일렬로 놓인 순서대로 주어진다. 각 수는 1이상 1,000이하의 자연수이다.</p>

### 출력 

 <p>첫째 줄에 원숭이가 N개의 바나나를 모두 옮기는 최소의 시간을 출력한다. 둘째 줄에 K개를 싸들고 가는 횟수를 출력하고, 그 다음 줄에 K개를 싸들고 가는 곳의 왼쪽 위치들을 오름차순 순서대로 출력한다. 답이 여러 개면 아무거나 출력해도 상관없다.</p>

