import Foundation
//let input = """
//7 8
//0 1 3
//1 1 7
//0 7 6
//1 7 1
//0 3 7
//0 4 2
//0 1 1
//1 1 1
//"""
let input = """
6 10
0 1 2
0 3 4
1 1 3
0 2 5
1 1 5
0 4 6
1 3 6
1 1 6
0 5 6
1 1 3
"""
var input2 = input.split(separator: "\n")
var first = input2.removeFirst().split(separator: " ").map{Int($0)!}
let (a,b) = (first[0], first[1])

var array = (0...a).map {$0}

for i in 0..<b {
    let statement = input2[i].split(separator: " ").map{Int($0)!}
    let (qu, el1, el2) = (statement[0], statement[1], statement[2])
    if qu == 0 {
        union(el1, el2)
    }
    else {
        if checkSame(el1, el2) {
            print("YES")
        }
        else {
            print("NO")
        }
    }
}

func union(_ el1: Int, _ el2: Int) {
    var el1 = find(el1)
    var el2 = find(el2)
    
    if el1 != el2 {
        array[el2] = el1
    }
}
func find(_ el1: Int) -> Int {
    if array[el1] == el1 {
        return el1
    } 
    else {
        array[el1] = find(array[el1])
        return array[el1]
    }
}
func checkSame(_ el1: Int, _ el2: Int) -> Bool{
    return find(el1) == find(el2)
}


