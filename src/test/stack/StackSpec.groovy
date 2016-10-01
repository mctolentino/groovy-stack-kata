package stack

import spock.lang.Specification

class StackSpec extends Specification {
    private Stack stack

    void setup() {
        stack = Stack.Make(2)
    }

    def 'new stack should be empty'() {
        expect:
        stack.size() == 0
        stack.isEmpty() == true
    }

    def 'after one push, stack size should be one'() {
        when:
        stack.push(1)

        then:
        stack.size() == 1
        stack.isEmpty() == true
    }

    def 'after one push and one pop, stack should be empty'() {
        when:
        stack.push(1)
        stack.pop()

        then:
        stack.size() == 0
        stack.isEmpty()
    }

    def 'when pushed past stack capacity, should throw StackOverflow exception'() {
        when:
        stack.push(1)
        stack.push(1)
        stack.push(1)

        then:
        thrown(Stack.OverflowException)
    }

    def 'when an empty stack is popped, should throw Underflow exception'() {
        when:
        stack.pop()

        then:
        thrown(Stack.UnderflowException)
    }

    def 'when 1 is pushed, 1 is popped'() {
        when:
        stack.push(1)

        then:
        stack.pop() == 1
    }

    def 'when 1 and 2 are pushed, 2 and 1 are popped'() {
        when:
        stack.push(1)
        stack.push(2)

        then:
        stack.pop() == 2
        stack.pop() == 1
    }

    def 'when 1 and 2 are pushed, pop, and 3 is pushed, 3 and 1 should be popped'() {
        when:
        stack.push(1)
        stack.push(2)
        stack.pop()
        stack.push(3)

        then:
        stack.pop() == 3
        stack.pop() == 1
        stack.isEmpty()
    }

    def 'last item to be pushed is top'() {
        when:
        stack.push(1)

        then:
        stack.top() == 1
        stack.size() == 1

        when:
        stack.push(2)

        then:
        stack.top() == 2
        stack.size() == 2
    }

}
