package main.steronline.mcv.kr.cmd;

import main.steronline.mcv.kr.data.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        String name;
        ConfigManager config;
        if (args.length != 0) {
            switch (args[0]) {
                case "아이템":
                    switch (args[1]) {
                        case "추가":
                            name = args[2];
                            config = new ConfigManager(name);
                            config.newArrayList("test");
                            config.addObject("test","test");
                            Inventory inv = Bukkit.createInventory(null,45,name);
                            player.openInventory(inv);
                            break;
                        case "설정":
                            name = args[2];

                            break;
                    }
                    break;
                case "목록":

                    break;
                case "가공기":
                    switch (args[1]) {
                        case "추가":
                            name = args[2];
                            config = new ConfigManager(name);

                            break;
                        case "설정":
                            name = args[2];

                            break;
                    }
                    break;

            }
        } else {
            sendMessage(player);
        }
        return false;
    }

    public void sendMessage(Player player) {
        player.sendMessage("/가공: 명령어를 확인합니다.");
        player.sendMessage("/가공 아이템 추가 레시피이름: 가공 GUI를 엽니다. 왼쪽 빈 칸에 가공재료를 넣고(4칸) 그 오른쪽빈칸에 재료 아이템으로 나오는 아이템을 설정합니다.");
        player.sendMessage("/가공 아이템 설정 레시피이름: 위 GUI를 열고 재설정합니다.");
        player.sendMessage("/가공 목록: 위 가공 아이템들 레시피와 리스트 목록을 텍스트로 봅니다.");
        player.sendMessage("/가공 가공기 추가: 이 명령어를 치고 우클릭한 블럭을 가공기로 설정합니다.");
        player.sendMessage("§c[ 가공기는 등록한 레시피만 가공할 수 있습니다. ]");
        player.sendMessage("/가공 가공기 설정 레시피이름: 해당 이름의 레시피를 우클릭한 가공기에 등록합니다.");

    }
}
