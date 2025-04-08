package com.example.kotlinstudy

//문제
//태수가 즐겨하는 디제이맥스 게임은 각각의 노래마다 랭킹 리스트가 있다. 이것은 매번 게임할 때 마다 얻는 점수가 비오름차순으로 저장되어 있는 것이다.
//이 랭킹 리스트의 등수는 보통 위에서부터 몇 번째 있는 점수인지로 결정한다. 하지만, 같은 점수가 있을 때는 그러한 점수의 등수 중에 가장 작은 등수가 된다.
//예를 들어 랭킹 리스트가 100, 90, 90, 80일 때 각각의 등수는 1, 2, 2, 4등이 된다
//랭킹 리스트에 올라 갈 수 있는 점수의 개수 P가 주어진다. 그리고 리스트에 있는 점수 N개가 비오름차순으로 주어지고, 태수의 새로운 점수가 주어진다.
//이때, 태수의 새로운 점수가 랭킹 리스트에서 몇 등 하는지 구하는 프로그램을 작성하시오.
//만약 점수가 랭킹 리스트에 올라갈 수 없을 정도로 낮다면 -1을 출력한다.
//만약, 랭킹 리스트가 꽉 차있을 때, 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다.

//첫째 줄에 N, 태수의 새로운 점수, 그리고 P가 주어진다. P는 10보다 크거나 같고, 50보다 작거나 같은 정수, N은 0보다 크거나 같고, P보다 작거나 같은 정수이다.
//그리고 모든 점수는 2,000,000,000보다 작거나 같은 자연수 또는 0이다. 둘째 줄에는 현재 랭킹 리스트에 있는 점수가 비오름차순으로 주어진다.
//둘째 줄은 N이 0보다 큰 경우에만 주어진다.

// 점수 리스트 갯수 : N, 등수 P 까지

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val N = input[0]
    val score = input[1]
    val P = input[2]

    // 점수 리스트가 없으면 무조건 1등
    if (N == 0) {
        print(1)
        return
    }

    //점수를 내림차순으로 정렬
    val scoreList = readln().split(" ").map { it.toInt() }.take(N).sortedDescending().toMutableList()

    //태수의 점수가 들어갈 위치에
    val myScoreIndex = scoreList.indexOfLast { score <= it } + 1

    //삽입
    scoreList.add(myScoreIndex, score)

    // 만약 태수의 점수가 들어간 위치가 랭킹 밖이라면 -1
    if(myScoreIndex + 1 > P) print(-1)

    //그게 아니라면 태수의 점수와 똑같은 첫번째 점수의 랭크를 가져와서 출력
    else print(scoreList.indexOfFirst { score == it } + 1)
}
