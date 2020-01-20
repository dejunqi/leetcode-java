package nonleetcode.googleSnap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 Google Snapshot
 就 是 ⼀ 个 array ， 然 后 这 个 array 有 不 同 的 版 本 数 ， 然 后 有 不 同 的 函 数 ， ⽐ 如 set(int index, int val) ，
 get(int index, int version), snapshot() 。 ⽐ 如 说 我 先 set(1,1) ， set(0,0) ， set(2,2) ， 这 样 我 有 ⼀ 个
 [0,1,2] ， 然 后 snapshot() 之 后 系 统 ⾥ 会 记 住 version 1 的 array 是 [0,1,2] ， 然 后 set(1,0) ， array 就 变 成
 [0,0,2] ， 这 个 时 候 如 果 get(1,1) 得 到 的 是 1 ， 但 get(1,2) 得 到 的 是 0 。
 思 路 ：
 1. 模 拟 过 程 ， ⽤ map 存 下 snapshot 即 可, 主 要 要 和 ⾯ 试 官 交 流 得 到 各 种 异 常 的 处 理 ⽅ 式
 包 括 数 组 ⻓ 度 是 否 固 定 ， idx 是 否 ⼀ 定 合 法 ， version 不 存 在 是 返 回 最 近 的 还 是 抛 出 异 常 等 等
 2. hash map 嵌 套 treemap ， 牺 牲 了 ⼀ 些 时 间 ， 但 是 如 果 ⼀ 些 idx 在 某 些 version ⼀ 直 没 ⽤ 过 可 以 节
 省 空 间
 */

public class Snapshot {
    int version = 1;
    int length;

    Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    public Snapshot(int length) {
        this.length = length;
        for (int i = 0; i < length; i++) {
            map.put(i, new TreeMap<>());
        }
    }

    public void set(int idx, int val) {
        map.get(idx).put(version, val);
    }

    public void snapshot() {
        version++;
    }

    public int get(int idx, int version) {
        TreeMap<Integer, Integer> versions = map.get(idx);
        return versions.get(version);
    }
}
