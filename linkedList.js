
// Format for linked list
var linkedList = {
    head: {
        value: 5,
        next: {
            value: 11,
            next: {
                value: 14,
                next: null
            }
        }
    }
}

class Node{
    constructor(value){
        this.value = value;
        this.next = null;
    }
}

class SinglyLinkedListLib {
    constructor(value){
        this.head = new Node(value);
        this.tail = this.head;
        this.length = 1;
    }

    append(value){
        const newNode = new Node(value);
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
        return this;
    }

    prepend(value){
        const newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
        return this;
    }

    printList(){
        const values = [];
        let currentNode = this.head;
        while(currentNode != null){
            values.push(currentNode.value);
            currentNode = currentNode.next;
        }
        return values;
    }

    insert(index, value){
        const newNode = new Node(value);
        if(index >= this.length){
            this.length++;
            return this.append(value);
        }
        if(index === 0){
            this.length++;
            return this.prepend(value);
        }
        const leader = this.traverseTo(index-1);
        
        const holder = leader.next;
        leader.next = newNode;
        newNode.next = holder;

        this.length++;
        return this;
    }

    delete(index){
        const leader = this.traverseTo(index-1);
        const unwantedNode = leader.next;
        leader.next = unwantedNode.next;
        this.length--;
        return this;
    }

    traverseTo(index){
        var count = 0;
        let currentNode = this.head;
        while(count !== index){
            currentNode = currentNode.next;
            count++;
        }
        return currentNode;
    }

    reverse(){
        if(!this.head.next){
            return this.head;
        }
        let first = this.head;
        this.tail = this.head;
        let second = first.next;
        while(second){
            const temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        this.head.next= null;
        this.head = first;
        return this;
    }
}

// TODO: Move to other js file
const myLinkedList = new SinglyLinkedListLib(5);
myLinkedList.append(11);
myLinkedList.append(120);
myLinkedList.prepend(100);
// console.log(myLinkedList);
// console.log(myLinkedList.printList());
// myLinkedList.insert(10,50);
myLinkedList.insert(2,50);
// console.log(myLinkedList);
// console.log(myLinkedList.printList());
console.log(myLinkedList.printList());
myLinkedList.reverse();
console.log(myLinkedList.printList());