var input2 = [String]()
while let line = readLine() {
    input2.append(line)
}
var first = input2.removeFirst().split(separator: " ")
let (vertices, edges) = (Int(first[0])!, Int(first[1])!)
var tuples = [(Int, Int, Int)]()
var verticesWeight = 0
var edgesCount = 0
var array = (0...vertices).map{$0}

for i in 0..<input2.count {
    let newLine = input2[i].split(separator: " ").map {Int($0)!}
    tuples.append((newLine[0], newLine[1], newLine[2]))
}

tuples.sort {$0.2 < $1.2}

func union(_ a: Int, _ b: Int) -> Bool {
    var a = find(a)
    var b = find(b)
    if a != b {
        array[b] = a
        return true
    }
    return false

}

func find(_ a : Int) -> Int{
    if array[a] == a {
        return a
    }
    else {
        array[a] = find(array[a])
        return array[a]
    }
}
for tup in tuples {
    if union(tup.0, tup.1) {
        verticesWeight += tup.2
        edgesCount += 1 
        if edgesCount == vertices - 1 {
            break
        }
    }
}
print(verticesWeight)
