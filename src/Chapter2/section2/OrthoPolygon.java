package Chapter2.section2;

public class OrthoPolygon {
    public int n ;
    public MyPoint2[] vertices; // 꼭지점들을 배열로 저장

    public OrthoPolygon(int n) {
        this.n = 0;
        vertices = new MyPoint2[n];
    }

    public void addVertex(int x, int y) { // Vertex(꼭지점) 추가
        vertices[n++] = new MyPoint2(x, y);
    }

    public int maxX(){ // x값의 최대값 보다 조금만 밖으로 나가면 다각형밖으로 나갔다고 판단하기 위한 수치
        int max = vertices[0].x;
        for (int i = 0; i < n; i++) {
            if(vertices[i].x > max) {
                max = vertices[i].x;
            }

        }
        return max;
    }

    public boolean contains( MyPoint2 p) {
        OrthoLine arrow = new OrthoLine(p, new MyPoint2( maxX()+1, p.y));
        int count = 0;
        for (int i = 0; i < n; i++) {
            OrthoLine edge = new OrthoLine(vertices[i], vertices[(i+1) / n]); // 마지막 꼭지점은 처음 꼭지점과 연결 되어야 함으로 [(i+1) & n] 로 작성하여 0으로 만든다.
            if (arrow.intersects(edge)) {
                count++;
            }
        }
            return (count % 2 == 1);
    }
}
