import spock.lang.*

@Unroll
class MyStructureTest extends Specification {

    @Shared
    MyStructure myStructure = new MyStructure()

    def setupSpec() {

        INode iNode1 = new ICompositeImp("1", "6")
        INode iNode2 = new InodeImp("2", "7")
        INode iNode3 = new ICompositeImp("3", "8")
        INode iNode4 = new InodeImp("4", "9")
        INode iNode5 = new InodeImp("5", "10")

        myStructure.setNodes(List.of(iNode1))
        ((ICompositeImp) iNode1).setiNodes(List.of(iNode2, iNode3))
        ((ICompositeImp) iNode3).setiNodes(List.of(iNode4, iNode5))
    }

    def "Should find object by findByCode and execute getRenderer on him"() {
        when:
        def result = myStructure.findByCode(code).getRenderer()
        then:
        result == expectedResult
        where:
        code || expectedResult
        "1"  || "6"
        "2"  || "7"
        "3"  || "8"
        "4"  || "9"
        "5"  || "10"
    }

    def "Should return null because put on empty string like a param to findByCode"() {
        when:
        def result = myStructure.findByCode("")
        then:
        result == expectedResult
        where:
        expectedResult = null
    }

    def "Should return null because provided the param to findByCode wasn't found"() {
        when:
        def result = myStructure.findByCode("a")
        then:
        result == expectedResult
        where:
        expectedResult = null
    }

    def "Should involve exception because of wasn't put param to findByCode"() {
        when:
        myStructure.findByCode()
        then:
        thrown(IllegalArgumentException)
    }

    def "Should find object by findByRenderer and execute getCode on him"() {
        when:
        def result = myStructure.findByRenderer(renderer).getCode()
        then:
        result == expectedResult
        where:
        renderer || expectedResult
        "6"      || "1"
        "7"      || "2"
        "8"      || "3"
        "9"      || "4"
        "10"     || "5"
    }

    def "Should return null because put on empty string like a param to findByRender"() {
        when:
        def result = myStructure.findByRenderer("")
        then:
        result == expectedResult
        where:
        expectedResult = null
    }

    def "Should return null because provided the param to findByRender wasn't found"() {
        when:
        def result = myStructure.findByRenderer("a")
        then:
        result == expectedResult
        where:
        expectedResult = null
    }

    def "Should involve exception because of wasn't put param to findByRender"() {
        when:
        myStructure.findByRenderer()
        then:
        thrown(IllegalArgumentException)
    }

    def "Should return 5 when provided tree from setupSpec and executed count"() {
        when:
        def result = myStructure.count()
        then:
        result == expectedResult
        where:
        expectedResult = 5
    }

    def "Should return 0 when provided empty tree to myStructure and executed count"() {
        setup:
        List<INode> inodes = new ArrayList<>()
        myStructure.setNodes(inodes)
        when:
        def result = myStructure.count()
        then:
        result == expectedResult
        where:
        expectedResult = 0
    }
}