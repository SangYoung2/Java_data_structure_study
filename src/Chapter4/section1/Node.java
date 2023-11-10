package Chapter4.section1;

public class Node<T> {
    /*
        리스트
        - 기본적인 연산: 삽입(insert), 삭제(remove), 검색(search) 등 
        - 리스트를 구현하는 대표적인 두 가지 방법: 배열, 연결 리스트
        배열의 단점
        - 크기가 고정(reallocation필요)
        - 리스트의 중간에 원소를 삽입하거나 삭제할 경우 다수의 데이터를 옮겨야함
        연결리스트
        - 다른 데이터의 이동없이 중간에 삽입하거나 삭제가 가능
        - 길이의 제한이 없음
        - 랜덤 엑서스가 불가능
        노드
        - 각각의 노드는 "데이터 필드"와 하나 혹은 그 이상의 "링크 필드"로 구성
        - 링크 필드는 다음 노드를 참조
        - 첫 번째 노드의 주소는 따로 저장해야함
    */

    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
