package main.steronline.mcv.kr;
/***
 * 가공 시스템:
 *
 * /가공: 명령어를 확인합니다.
 * /가공 아이템 추가 레시피이름: 가공 GUI를 엽니다. 왼쪽 빈 칸에 가공재료를 넣고(4칸) 그 오른쪽빈칸에 재료 아이템으로 나오는 아이템을 설정합니다.
 * /가공 아이템 설정 레시피이름: 위 GUI를 열고 재설정합니다.
 * /가공 목록: 위 가공 아이템들 레시피와 리스트 목록을 텍스트로 봅니다.
 * /가공 가공기 추가: 이 명령어를 치고 우클릭한 블럭을 가공기로 설정합니다.
 * [ 가공기는 등록한 레시피만 가공할 수 있습니다. ]
 * /가공 가공기 설정 레시피이름: 해당 이름의 레시피를 우클릭한 가공기에 등록합니다.
 */

import main.steronline.mcv.kr.cmd.cmd;
import main.steronline.mcv.kr.event.InventoryClose;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Main extends JavaPlugin implements Listener {


    public static Main plugin;
    @Override
    public void onEnable() {
        super.onEnable();
        plugin = this;
        getCommand("가공").setExecutor(new cmd());
        Listener[] events = {new InventoryClose()};
        PluginManager pm = Bukkit.getPluginManager();
        Arrays.stream(events).forEach(classes -> {
            pm.registerEvents(classes, this);
        });
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
