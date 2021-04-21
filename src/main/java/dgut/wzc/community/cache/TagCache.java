package dgut.wzc.community.cache;

import dgut.wzc.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDTO> get(){
        ArrayList<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        //TAG类型
        program.setCategoryName("运动类型");
        //具体tag
        program.setTags(Arrays.asList("篮球","足球","乒乓球"));
        tagDTOS.add(program);

        TagDTO matchType = new TagDTO();
        matchType.setCategoryName("赛事类型");
        matchType.setTags(Arrays.asList("奥运会","世界杯","诺克斯"));
        tagDTOS.add(matchType);

        return tagDTOS;
    }
    public static String filterInvalid(String tags){
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));

        return invalid;
    }

}
