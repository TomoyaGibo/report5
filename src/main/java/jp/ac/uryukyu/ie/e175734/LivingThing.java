package jp.ac.uryukyu.ie.e175734;

/**
 * 生物クラス。
 * ゲームの敵や味方キャラを生成する元になるクラス。
 * String name; //生物の名前
 * int hitPoint; //体力
 * int attack; //攻撃力
 * boolean dead; //生死状態。true = 死んでいる状態。
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前，最大体力，攻撃力を指定する。
     * @param name 生成されるキャラクターの名前
     * @param hitPoint キャラクターのHP
     * @param attack キャラクターの攻撃力
     */
    public LivingThing(String name, int hitPoint, int attack) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }


    /**
     * 攻撃するメソッド。
     * 相手が死亡状態でない時，攻撃する。
     * @param livingThing 本クラス。ここでは，対象とする相手になる。
     */
    public void attack(LivingThing livingThing) {
        int damage = (int) (Math.random() * attack);
        if (dead == false) {
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, livingThing.getName(), damage);
            livingThing.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃された時にダメージ処理をするメソッド。
     * 受けたダメージをhitPointから引き，死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}